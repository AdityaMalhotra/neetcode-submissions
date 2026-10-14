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
        List<CarStatus> carsList = new ArrayList<>();
        for(int i=0;i<position.length;i++){
            carsList.add(new CarStatus(position[i],speed[i]));
        }

        Collections.sort(carsList);

        double previousTime = -1.0;
        int count = 0;

        for(int i=carsList.size()-1;i>-1;i--){
            int pos = carsList.get(i).position;
            int sp = carsList.get(i).speed;

            double time = ((double)(target-pos))/sp;

            if(time>previousTime){
                count++;
                previousTime = time;
            }
        }
        return count;
    }
}
