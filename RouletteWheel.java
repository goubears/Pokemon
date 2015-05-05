		/****************************************
         *                                      *
         *            Roulette Wheel            *
         *         Andrew Miller-Smith          *
         *                                      *
         ****************************************/

        /*

        Description:    A RouletteWheel for easy roulette selection in genetic algorithms. Constructor takes an ArrayList of fitness values,
        				which are used to form a wheel of probabilities. The selectValue() and selectAndRemove() methods generate a random
        				value and return the index of the corresponding individual. The remove() and selectAndRemove() methods remove an individual
        				(the latter after it has been selected) and reconstruct the wheel. Class tracks sum of fitnesses and includes basic
        				ArrayList functionality for the wheel. Class can also be used for general probabilistic selection and roulette wheel
        				functionality.

        				Copyright 2015, Andrew Miller-Smith. Class is free for non-commercial use. For commercial use, inquire at amillers@bowdoin.edu.

        */

import java.util.*;
import java.util.Random;
import java.util.Arrays;

public class RouletteWheel {

	//ArrayLists for storing inputs and wheel
	private ArrayList<Double> wheel = new ArrayList<Double>();
	private ArrayList<Double> inputs;
	
	//random number generator, variable to track sum of input values
	private double inputSum;
	private Random rand = new Random();
	
	//constructor takes ArrayList of doubles. List is then converted into a "wheel" (ArrayList) where each value is the sum of the previous
	//plus the new input value at that index. Creates an implicitly sorted list of probabilities we can use to select an individual
	public RouletteWheel(ArrayList<Double> inputList){

	 	//give inputList global access
	 	inputs = inputList;
	 	wheel.add(inputList.get(0));

	 	//create ArrayList of summed values
	 	for (int i = 1; i < inputList.size(); i++){
	 		wheel.add(wheel.get(i - 1) + inputList.get(i));
	 	}

	 	inputSum = wheel.get(wheel.size() - 1);
	 }

	//selectValue method "spins" the wheel by generating a random value between 0 and the sum of the inputs. A binary search finds where this
	//value would exist in the probability wheel. This index corresponds to the individual in the input ArrayList that has been chosen.
	//Returns the index of that individual in O(lgn) time
	public int selectValue(){

	 	//make sure wheel is not empty
	 	if (wheel.size() == 0){
	 		System.out.println("Error: wheel is empty. Cannot select or remove.");
	 		return -1;
	 	}
	 	//generate random value between 0 and inputSums, locate appropriate index with binarySearch
	 	double value = rand.nextDouble()*inputSum;
	 	int index = Collections.binarySearch(wheel, value);

	 	//if index is negative, adjust accordingly
	 	if (index < 0){
	 		index = -index - 1;
	 	}

	 	return index;
	 }

	 //selectAndRemove method selects an individual as outlined in the selectValue method then removes this individual.
	 //selection runs in O(lgn), but removal and reconstruction of the wheel runs in O(n) time, making the method linear.
	 //returns index of selected and removed individual
	 public int selectAndRemove(){

	 	//make sure wheel is not empty
	 	if (wheel.size() == 0){
	 		System.out.println("Error: wheel is empty. Cannot select or remove.");
	 		return -1;
	 	}
	 	//generate random value between 0 and inputSums, locate appropriate index with binarySearch
	 	double value = rand.nextDouble()*inputSum;
	 	int index = Collections.binarySearch(wheel, value);

	 	//if index is negative, adjust accordingly
	 	if (index < 0){
	 		index = -index - 1;
	 	}

	 	remove(index);
	 	return index;
	 }

	 //remove method takes the index of an individual to remove from the pool of individuals. Rebuilds the probability
	 //wheel after removal in O(n) time. Returns void.
	 public void remove(int index){

	 	//make sure wheel isn't empty
	 	if(inputs.isEmpty()){
	 		System.out.println("Error: wheel is empty.");
	 		return;
	 	}

	 	//make sure index exists
	 	if (index >= inputs.size() && index != 0){
	 		System.out.println("Error: index " + index + " exceeds size of wheel.");
	 		return;
	 	}
	 	inputs.remove(index);

	 	//if inputs is now empty, don't bother rebuilding wheel
	 	if (inputs.isEmpty()){
	 		inputSum = 0;
	 		wheel.clear();
	 		return;
	 	}

	 	//update wheel values accordingly
	 	if (index == 0){

	 		//rebuild wheel
	 		wheel.clear();
	 		wheel.add(inputs.get(0));

		 	//create ArrayList of summed values
		 	for (int i = 1; i < inputs.size(); i++){
		 		wheel.add(wheel.get(i - 1) + inputs.get(i));
		 	}
	 	}
	 	else{

		 	//remove all values after and including specified index
		 	for (int i = wheel.size() - 1; i >= index; i--){
		 		wheel.remove(i);
		 	}

		 	//rebuild remaining part of wheel
		 	for (int i = index; i < inputs.size(); i++){
		 		wheel.add(wheel.get(i - 1) + inputs.get(i));
		 	}
		 }

		 inputSum = wheel.get(wheel.size() - 1);
	 }

	//a simple method to print out the values of the probability wheel. Used mostly for testing purposes, but nice functionality to have. Returns void.
	public void printValues(){

		for (int i = 0; i < wheel.size(); i++){
			System.out.println("Wheel value at index " + i + ": " + wheel.get(i));
		}
	}
	//returns current sum of inputs in wheel
	public double getSum(){
			return inputSum;
	}

	//basic ArrayList functions for the wheel
	public boolean isEmpty(){
		return wheel.isEmpty();
	}
	public int size(){
		return wheel.size();
	}

	/*The Enrichment Center promises to always provide a safe testing environment. In dangerous testing environments, 
      the Enrichment Center promises to always provide useful advice. For instance, the floor here will kill you. Try to avoid it.*/
}