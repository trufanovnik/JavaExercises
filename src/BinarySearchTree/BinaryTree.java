package BinarySearchTree;

public class BinaryTree<K extends Comparable<K>, V> {
    Node<K, V> root;

    private Node<K, V> addRecursive(Node<K, V> current, K key, V value){
        if(current == null) {
            return new Node<>(key, value);
        }
        if(key.compareTo(current.key) < 0){
            current.left = addRecursive(current.left, key, value);
        } else if (key.compareTo(current.key) > 0) {
            current.right = addRecursive(current.right, key, value);
        } else {
            current.value = value;
        }
        return current;
    }

    public void add(K key, V value){
        root = addRecursive(root, key, value);
    }

    public V getRecursive(Node<K, V> current, K key){
            if(current == null){
                return null;
            }
            if (key.compareTo(current.key) == 0) {
                return current.value;
            }
            return key.compareTo(current.key) < 0
                ? getRecursive(current.left, key)
                : getRecursive(current.right, key);
    }

    public V get(K key){
        return getRecursive(root, key);
    }
}
