class User{
    Set<Integer> followedBy;
    PriorityQueue<int[]> newsfeed;
    PriorityQueue<int[]> posts;
    User(){
        this.followedBy = new HashSet<>();
        this.newsfeed = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        this.posts = new PriorityQueue<>((a,b)->(a[0]-b[0]));
    }
    public List<Integer> getNewsFeed(){
        List<Integer> resultList = newsfeed.stream()
                .sorted(newsfeed.comparator())   // 1. Force the stream to sort by priority
                .map(arr -> arr[1])        // 2. Map int[] to just the 0th element
                .collect(Collectors.toList()); // 3. Collect into List<Integer>

        return resultList.reversed();
    }
    public Set<Integer> getFollowers(){
        return this.followedBy;
    }
    public PriorityQueue<int[]> getPosts(){
        return this.posts;
    }
    public void updateFeed(int counter,int tweetId,int userId){
        this.newsfeed.add(new int[]{counter,tweetId,userId});
        if(this.newsfeed.size()>10){
            this.newsfeed.poll();
        }
    }

    public void mergeFeed(PriorityQueue<int[]> postsOfFriend){
        System.out.println("Following process");
        Set<int[]> temp = new HashSet<>();
        PriorityQueue<int[]> postsOfFriendCpy = new PriorityQueue<int[]>(postsOfFriend);
        while(!this.newsfeed.isEmpty()){
            int[] data = this.newsfeed.poll();
            temp.add(new int[]{data[0],data[1],data[2]});
        }
        while(!postsOfFriendCpy.isEmpty()){
            int[] data = postsOfFriendCpy.poll();
            temp.add(new int[]{data[0],data[1],data[2]});
        }
        for(int[] d:temp){
            System.out.println(d[0]+" t"+d[1]+" u"+d[2]);
            this.newsfeed.add(d);
        }
        curbFeed();
    }
    void curbFeed(){
        while(this.newsfeed.size()>10){
            this.newsfeed.poll();
        }
    }
    public void post(int counter,int tweetId,int userId){
        this.posts.add(new int[]{counter,tweetId,userId});
        if(this.posts.size()>10){
            this.posts.poll();
        }
    }

    public void follow(int userId){
        this.followedBy.add(userId);

    }

    public void unfollow(int userId){
        this.followedBy.remove(userId);
    }

    public void removePosts(int userId){
        Set<ArrayList<Integer>> temp = new HashSet<>();
        System.out.println("unfollowing...");
        while(!this.newsfeed.isEmpty()){
            int[] data = this.newsfeed.poll();

            if(data[2]!=userId){
                ArrayList<Integer> list = new ArrayList<>();
                for (int val : data) {
                    list.add(val);
                }
                temp.add(list);
            }
        }

        PriorityQueue<int[]> postsCpy = new PriorityQueue<>(posts);
        while(!postsCpy.isEmpty()){
            int[] data = postsCpy.poll();
            ArrayList<Integer> list = new ArrayList<>();
                for (int val : data) {
                    list.add(val);
                }
            temp.add(list);
        }
        for(ArrayList<Integer> d:temp){
            System.out.println(d.get(0)+" "+d.get(1));
            this.newsfeed.add(new int[]{d.get(0),d.get(1),d.get(2)});
    
        }
        curbFeed();

    }
    public boolean isFollowedBy(int followerId){
        return this.followedBy.contains(followerId);
    }

}
class Twitter {
    int counter=0;
    Map<Integer,User> umap = new HashMap<>();
    public Twitter() {
        /*
        User
        followedBy
        newsfeed (minheap - combined pq - limited to 10)
        posts (minheap - posted by user - limited to 10)

        post tweet
        inc counter
        add to the posts pq with counter
        and update the news feed of the followers & self

        get news feed
        just get the newsfeed

        follow A,B
        B's followedby A add 1
        and update the news feed of A

        unfollow A,B
        A unfollows B
        update news feed of A

        updateFeed(user,post)
        */
        for(int i=1;i<=100;i++){
            umap.put(i,new User());
        }
    }
    
    public void postTweet(int userId, int tweetId) {
        this.counter++;
        User u = umap.get(userId);
        System.out.println(userId+"  "+counter);
        u.post(counter,tweetId,userId);
        u.updateFeed(counter,tweetId,userId);
        for(int f:u.getFollowers()){
            User friend = umap.get(f);
            friend.updateFeed(counter,tweetId,userId);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        User u = umap.get(userId);
        return u.getNewsFeed();
    }
    
    public void follow(int followerId, int followeeId) {
        User followee = umap.get(followeeId);
        if(followerId==followeeId || followee.isFollowedBy(followerId)==true){
            return;
        }
        followee.follow(followerId);
        User follower = umap.get(followerId);
        follower.mergeFeed(followee.getPosts());
    }
    
    public void unfollow(int followerId, int followeeId) {
        User followee = umap.get(followeeId);
        if(followerId==followeeId || followee.isFollowedBy(followerId)==false){
            return;
        }
        followee.unfollow(followerId);
        User follower = umap.get(followerId);
        follower.removePosts(followeeId);
    }
}
