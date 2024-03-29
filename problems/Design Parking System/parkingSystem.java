class ParkingSystem {

    public ParkingSystem(int big, int medium, int small) {
        // Parking limit for each type of car
        this.bigLimit = big;
        this.mediumLimit = medium;
        this.smallLimit = small;

        // Create an Array to store parked cars
        this.parkingArray = new int[big + medium + small];
        for (int i = 0; i < this.parkingArray.length; i++) {
            this.parkingArray[i] = 0;
        }
    }

    public boolean addCar(int carType) {
        // Depending on carType, store the limit for the type of car
        int limit = 0;
        if (carType == 1) {
            limit = this.bigLimit;
        } else if (carType == 2) {
            limit = this.mediumLimit;
        } else {
            limit = this.smallLimit;
        }

        // Traverse linearly through the array from the left
        int count = 0;
        for (int i = 0; i < this.parkingArray.length; i++) {

            // Count the number of cars parked in the system of that type
            if (this.parkingArray[i] == carType) {
                count++;
            }

            // Stop if the count becomes equal to the limit
            if (count == limit) {
                return false;
            }

            // If the count is less than the limit, then add the car
            // to the first available empty slot from the left
            if (this.parkingArray[i] == 0) {
                this.parkingArray[i] = carType;
                return true;
            }
        }

        // If no empty slot is found, then return False.
        // However, this line will never be executed if count < limit
        // because slot will be found before count becomes equal to limit
        return false;
    }

    // Parking limit for each type of car
    int bigLimit, mediumLimit, smallLimit;

    // Create an Array to store parked cars
    int[] parkingArray;
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
