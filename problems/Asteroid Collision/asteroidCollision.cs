public class Solution {
    public int[] AsteroidCollision(int[] asteroids) {
        Stack<int> store = new Stack<int>();

        foreach (int asteroid in asteroids) {
            if (0 == store.Count) {
                store.Push(asteroid);
            } else {
                int lastAsteroid = asteroid;

                while (0 < store.Count && 0 < store.Peek() && 0 > lastAsteroid) {
                    if (0 == store.Peek() + lastAsteroid) {
                        store.Pop();
                        lastAsteroid = 0;
                    } else if (0 < store.Peek() + lastAsteroid) {
                        lastAsteroid = 0;
                    } else {
                        store.Pop();
                    }
                }

                if (0 != lastAsteroid) {
                    store.Push(lastAsteroid);
                }
            }
        }

        return store.Reverse().ToArray();
    }
}
