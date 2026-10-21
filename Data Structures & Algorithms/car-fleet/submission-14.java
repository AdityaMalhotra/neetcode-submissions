class Solution {

    class CarStatus implements Comparable<CarStatus>{
        int position;
        int speed;

        CarStatus(int position, int speed){
            this.position = position;
            this.speed = speed;
        }

        @Override
        public int compareTo(CarStatus other){
            return this.position - other.position;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        List<CarStatus> carStatusList = new ArrayList<>();
        for(int i=0;i<position.length;i++){
            carStatusList.add(new CarStatus(position[i],speed[i]));
        }
        Collections.sort(carStatusList);

        int fleetCount = 0;
        double prevTime = -1.0;
        for(int i=carStatusList.size()-1;i>-1;i--){
            CarStatus carStatus = carStatusList.get(i);
            int pos = carStatusList.get(i).position;
            int sp = carStatusList.get(i).speed;

            double time = ((double)(target - pos))/sp;
            if(time > prevTime){
                fleetCount++;
                prevTime = time;
            }
        }
        return fleetCount;
    }
}
