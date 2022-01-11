
import java.util.ArrayList;

public class HashMap<K, V> {

	// in each "bucket" it's a hashNode<>
	private ArrayList<HashNode<K, V>> bucket;

	// it's usually 16, but we only use 10 here
	private int numBuckets = 6;

	private int size;

	public HashMap() {
		this.bucket = new ArrayList<>();

		// we add 10 to it
		for (int i = 0; i < numBuckets; i++) {
			bucket.add(null);
		}
	}

	public int getSize() {

		// how many elements in the arraylist
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	// we get the "index" of the object we want to save in the arraylist
	private int getBucketIndex(K key) {
		// hashcode method return value will return negative number too, we use abs()
		int hashCod = Math.abs(key.hashCode());
		return hashCod % numBuckets;
	}

	public V get(K key) {
		int index = getBucketIndex(key);

		// we get the index of the bucket (the location in the arraylist)
		// it's a hashNode or null
		HashNode<K, V> head = bucket.get(index);

		// if there's object
		while (head != null) {

			// check if the object is the same key
			if (head.getKey().equals(key)) {
				return head.getValue();
			}

			// if it's not, we proceed to the next node
			head = head.next;
		}
		return null;
	}

	public V remove(K key) {
		int index = getBucketIndex(key);
		HashNode<K, V> head = bucket.get(index);

		// if it's null, it means the key is not existing at all
		if (head == null) {
			return null;
		}

		// check the first node if it's the node we want to remove
		// if so, we assign the next node to the current node
		if (head.getKey().equals(key)) {
			V val = head.getValue();
			head = head.next;
			bucket.set(index, head);
			size--;
			return val;

			// this means the first node is not the node we look for, we then will preceed to this part
		} else {

			// we created a temporary 'prev' node for use
			HashNode<K, V> prev = null;
			while (head != null) {

				// this exec when we find the key-value pair
				if (head.getKey().equals(key)) {
					// when execute this part of code, we know that the HahsNode will definately not the first of the index
					// it probably is the 2nd, 3rd, ... etc
					prev.next = head.next;
					size--;
					return head.getValue();
				}

				// we preceed to the next hashNode 
				prev = head;
				head = head.next;
			}

			// if non of above return, it means there is not the key-value pair in the index we stored.
			return null;
		}
	}

	public void add(K key, V value) {

		int index = getBucketIndex(key);
		HashNode<K, V> head = bucket.get(index);

		// create a temp Hashnode for use
		HashNode<K, V> toAdd = new HashNode<>();
		toAdd.key = key;
		toAdd.value = value;
		// if it's null, it means there is no hashnode in that index
		if (head == null) {
			bucket.set(index, toAdd);
			size++;

			// it's not null, means there's a least one node
		} else {
			while (head != null) {
				// check the first node, then next, then next until the last node ( a null node)
				if (head.key.equals(key)) {
					head.value = value;
					size++;
					break;
				}
				head = head.next;
			}

			// if it's a null node, it means we are at the last node of the index
			if (head == null) {
				// it's the first node of the index
				head = bucket.get(index);
				// this temp node's next node is the "first node of the index"
				// which means it becomes the first node of the index, the head node becomes the second
				toAdd.next = head;
				bucket.set(index, toAdd);
				size++;
			}
		}
		// if the arraylist size is greater than 70%, we add more index to the hashmap
		if ((1.0 * size) / numBuckets > 0.7) {
			ArrayList<HashNode<K, V>> tmp = bucket;
			bucket = new ArrayList<>();
			numBuckets = 2 * numBuckets;
			for (int i = 0; i < numBuckets; i++) {
				bucket.add(null);
			}
			for (HashNode<K, V> headNode : tmp) {
				while (headNode != null) {
					add(headNode.key, headNode.value);
					headNode = headNode.next;
				}
			}

		}

	}
}
