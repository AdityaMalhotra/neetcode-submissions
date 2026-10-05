class Solution {
    class CarState implements Comparable<CarState>{
        public int position;
        public int speed;

        public int compareTo(CarState other){
            return this.position - other.position;
        }

        public CarState(int position, int speed){
            this.position = position;
            this.speed = speed;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        List<CarState> carStates = new ArrayList<>();
        for(int i=0;i<position.length;i++){
            CarState state = new CarState(position[i],speed[i]);
            carStates.add(state);
        }
        Collections.sort(carStates);
        Deque<Double> stack = new ArrayDeque<>();
        for(CarState cs : carStates){
            stack.push((double)((target - cs.position)/cs.speed));
        }
        int count = 0;
        int prev = -1;
        while(!stack.isEmpty()){
            Double popped = stack.pop();
            if(popped>prev){
                count++;
            }
        }
        return count-1;
    }
}
