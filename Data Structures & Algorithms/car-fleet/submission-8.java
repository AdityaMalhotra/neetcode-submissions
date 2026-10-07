class Solution {

    class CarStatus implements Comparable<CarStatus>{
        int position;
        int speed;

        public CarStatus(int position,int speed){
            this.position = position;
            this.speed = speed;
        }

        public int compareTo(CarStatus that){
            return this.position - that.position;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        List<CarStatus> list = new ArrayList<>();
        for(int i=0;i<position.length;i++){
            list.add(new CarStatus(position[i],speed[i]));
        }
        Collections.sort(list);

        Deque<Double> stack = new ArrayDeque<>();

        for(int i=list.size()-1;i>-1;i--){
            int pos = list.get(i).position;
            int sp = list.get(i).speed;
            double timeToReach = ((double)(target - pos))/sp;

            if(stack.isEmpty() || stack.peek() < timeToReach){
                stack.push(timeToReach);
            }
        }

        return stack.size();

        // Input: target = 10, position = [4,1,0,7], speed = [2,2,1,1] (10-4)/2 = 3. 
    }
}
