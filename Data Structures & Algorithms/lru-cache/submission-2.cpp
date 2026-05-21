#include <bits/stdc++.h>
using namespace std;

class Node {
public:
    int key, value;
    Node* prev;
    Node* next;

    Node(int k, int v) {
        key = k;
        value = v;
        prev = next = nullptr;
    }
};

class LRUCache {
private:
    unordered_map<int, Node*> mp;
    int cap;
    Node* head;  // LRU
    Node* tail;  // MRU

    // Remove a node from DLL
    void remove(Node* node) {
        if (!node) return;

        if (node == head) head = head->next;
        if (node == tail) tail = tail->prev;

        if (node->prev) node->prev->next = node->next;
        if (node->next) node->next->prev = node->prev;
    }

    // Insert node at tail (MRU)
    void insertAtTail(Node* node) {
        if (!tail) {
            head = tail = node;
        } else {
            tail->next = node;
            node->prev = tail;
            tail = node;
        }
    }

public:
    LRUCache(int capacity) {
        cap = capacity;
        head = tail = nullptr;
    }

    int get(int key) {
        if (mp.find(key) == mp.end())
            return -1;

        Node* node = mp[key];
        remove(node);
        insertAtTail(node);
        return node->value;
    }

    void put(int key, int value) {
        // Key already exists
        if (mp.find(key) != mp.end()) {
            Node* node = mp[key];
            node->value = value;
            remove(node);
            insertAtTail(node);
            return;
        }

        // Cache full → evict LRU
        if (mp.size() == cap) {
            mp.erase(head->key);
            Node* temp = head;
            remove(head);
            delete temp;
        }

        Node* node = new Node(key, value);
        insertAtTail(node);
        mp[key] = node;
    }
};