class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        //pos
        //speed
        //target = dest
        //cannot take over another car position can be <=next pos, if pos is same, speed is same.
        // Fleet = set of cars at same pos, same speed.
        //Moment the fleet reaches target, its a part of that fleet.
        //count of car fleets.
        Deque<Double> stack = new ArrayDeque<>();
        Set<Double> unique = new HashSet<>();
        for(int i = 0;i<position.length;i++){
            // stack.push((target-position[i])/speed[i]);
            unique.add((double)((target-position[i])/speed[i]));
        }
        // int prev = -1;
        // while(!stack.isEmpty()){
        //     popped = stack.pop();
        //     if(popped!=prev){
        //         unique.add(popped);
        //         fleetCount++;
        //         prev = popped;
        //     }
        // }
        return unique.size();
    }
}
