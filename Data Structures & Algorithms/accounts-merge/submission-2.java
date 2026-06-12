class Solution {
    public String find(String n1,Map<String,String> hmap){
        if(!hmap.get(n1).equals(n1)){
            hmap.put(n1,find(hmap.get(n1),hmap));
            return hmap.get(n1);
        }
        return hmap.get(n1);
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        /*
        we need a DSU of hmap[Node]:Node
        finally we should have a set of strings
        then we need a hmap[primaryEmail]:list of string
        then just give list of values of the hmap


        neet 
        take 0th node : name

        take emails and keep joining
        */
        // parent hash map
        Map<String,String> hmap = new HashMap<>();
        Map<String,String> emailNameMap = new HashMap<>();
        for(int i=0;i<accounts.size();i++){
            
            String name = accounts.get(i).get(0);
            int limit = accounts.get(i).size();
            for(int j=1;j<limit;j++){
                String n1 = accounts.get(i).get(j);
                emailNameMap.put(n1,name);
                if(!hmap.containsKey(n1)){
                    hmap.put(n1,n1);
                }
                String n2 = "";
                if(j+1<limit){
                    n2 = accounts.get(i).get(j+1);
                    emailNameMap.put(n2,name);
                    if(!hmap.containsKey(n2)){
                        hmap.put(n2,n2);
                    }
                }
                if(!n2.equals("")){
                    // union 
                    String p1 = find(n1,hmap);
                    // System.out.println("parent of "+n1+" is "+p1);
                    String p2 = find(n2,hmap);
                    // System.out.println("parent of "+n2+" is "+p2);
                    if(!p1.equals(p2)){
                        //different set
                        
                        hmap.put(p2,p1);
                        find(p2,hmap);
                        for(Map.Entry<String,String> entry:hmap.entrySet()){
                            String n = entry.getKey();
                            String parent = entry.getValue();
                       }
                    }
                }
            }

        }
        List<String> names =  new ArrayList<>();
        Map<String,Set<String>> mp = new HashMap<>();
        for(Map.Entry<String,String> entry:hmap.entrySet()){
            String n = entry.getKey();
            String parent = find(entry.getValue(),hmap);
            mp.computeIfAbsent(parent,k->new HashSet()).add(n);
        }

        List<List<String>> ans = new ArrayList<>();
        int i = 0;
        for(Map.Entry<String,Set<String>> entry:mp.entrySet()){
            ans.add(new ArrayList<>(entry.getValue()));
            ans.get(i).add(0,emailNameMap.get(entry.getKey()));
            i++;
        }

        return ans;
    }
}