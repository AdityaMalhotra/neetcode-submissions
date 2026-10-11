class Solution {
    class CarStatus implements Comparable<CarStatus>{
        int position;
        int speed;

        public CarStatus(int position, int speed){
            this.position = position;
            this.speed = speed;
        }

        public int compareTo(CarStatus that){
            return this.position - that.position;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        List<CarStatus> list = new ArrayList<>();
        for(int i = 0;i<position.length;i++){
            list.add(new CarStatus(position[i],speed[i]));
        }
        Collections.sort(list);

        Deque<Double> stack = new ArrayDeque<>();

        int lastTimeToReach = -1;
        int count = 0;

        for(int i=list.size()-1;i>-1;i--){
            double timeToReach = ((double)(target-list.get(i).position))/list.get(i).speed;
            if(stack.isEmpty() || stack.peek()< timeToReach){
                stack.push(timeToReach);
            }
        }
        return stack.size();
    }
}
