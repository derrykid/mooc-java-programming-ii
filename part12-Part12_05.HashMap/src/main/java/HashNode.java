/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author derry
 */
import java.util.ArrayList;
public class HashNode<K, V> {
	// this is the pair created for hashmap

	public K key;
	public V value;
	public HashNode<K, V> next;

	public HashNode() {
		this.key = null;
		this.value = null;
	}
	
	public HashNode(K key, V value) {
		this.key = key;
		this.value = value;

	}

	public K getKey() {
		return this.key;
	}

	public V getValue() {
		return this.value;
	}

	public void setValue(V value) {
		this.value = value;
	}
}
