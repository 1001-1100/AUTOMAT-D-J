import java.util.ArrayList;

public class Algorithm{

	Automaton automaton;
	ArrayList<ArrayList<State>> visualStates;
	ArrayList<ArrayList<String>> solutionInputs;
	ArrayList<ArrayList<State>> lowestVisualStates;
	ArrayList<ArrayList<String>> lowestSolutionInputs;
	
	public Algorithm(Automaton automaton) {
		this.automaton = automaton;
		visualStates = new ArrayList<>();
		solutionInputs = new ArrayList<>();
		lowestVisualStates = new ArrayList<>();
		lowestSolutionInputs = new ArrayList<>();
		State initState = automaton.getStates().get(0);
		ArrayList<State> visited = new ArrayList<>();
		visited.add(initState);
		ArrayList<String> solution = new ArrayList<>();
		
		// Start the algorithm by calling the recursive function at the initial state
		
		recursiveSearch(initState,visited,solution);
		
		int lowestMove = solutionInputs.get(0).size();
		for(int i = 1 ; i < solutionInputs.size() ; i++) {
			if(lowestMove > solutionInputs.get(i).size()) {
				lowestMove = solutionInputs.get(i).size();
			}
		}
		for(int i = 0 ; i < solutionInputs.size() ; i++) {
			if(lowestMove == solutionInputs.get(i).size()) {
				lowestVisualStates.add(visualStates.get(i));
				lowestSolutionInputs.add(solutionInputs.get(i));
			}
		}
	}
	
	// Recursive function
	public void recursiveSearch(State state, ArrayList<State> alreadyVisited, ArrayList<String> inputSolution) {
		if(!state.isFinal) {
			for(int i = 0 ; i < state.getTransitions().size() ; i++) { // Loop through all the transitions of the current state
				String nextState = state.getTransitions().get(i).getDestination().replace("q", "");
				int stateNumber = Integer.parseInt(nextState);
				State newState = automaton.getStates().get(stateNumber);
				if(!alreadyVisited.contains(newState)) { // If the destination of the transition is already visited, it ignores the transition
					// Add the destination state to the visited states, and call the recursive function on the destination state
					alreadyVisited.add(newState);
					inputSolution.add(state.getTransitions().get(i).getInput());
					recursiveSearch(newState, alreadyVisited, inputSolution);
					alreadyVisited.remove(alreadyVisited.size()-1);
					inputSolution.remove(inputSolution.size()-1);
				}
			}
		}else {
			ArrayList<State> newAlreadyVisited = new ArrayList<>();
			ArrayList<String> newInputSolution = new ArrayList<>();
			newAlreadyVisited.addAll(alreadyVisited);
			newInputSolution.addAll(inputSolution);
			addVisitedState(newAlreadyVisited);
			addInput(newInputSolution);
		}
	}
	
	public void addVisitedState(ArrayList<State> visited) {
		this.visualStates.add(visited);
	}
	
	public void addInput(ArrayList<String> solution) {
		this.solutionInputs.add(solution);
	}	
	
}
