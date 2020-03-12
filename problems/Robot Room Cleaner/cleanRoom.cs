/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public bool Move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void TurnLeft();
 *     public void TurnRight();
 *
 *     // Clean the current cell.
 *     public void Clean();
 * }
 */
class Solution {
    public void CleanRoom(Robot robot) {
        ISet<(int, int)> cleanedCells = new HashSet<(int, int)>();
        Stack<(int, int)> stack = new Stack<(int, int)>();
        _currentCell = (0, 0);
        _dirIdx = 0;

        do
        {
            var prev = _currentCell;
            if (!Clean(robot, cleanedCells))
            {
                stack.Pop();
            }

            bool move = false;
            for (int i = 0; i < 4; i++)
            {
                var next = (_currentCell.Item1 + _directions[_dirIdx].Item1, _currentCell.Item2 + _directions[_dirIdx].Item2);
                if (!cleanedCells.Contains(next) && Move(robot))
                {
                    move = true;
                    break;
                }

                TurnLeft(robot);
            }

            if (move)
            {
                stack.Push(prev);
                continue;
            }

            if (stack.Count == 0)
            {
                break;
            }

            var back = stack.Peek();
            (int, int) targetDir = (back.Item1 - _currentCell.Item1, back.Item2 - _currentCell.Item2);


            while (_directions[_dirIdx].Item1 != targetDir.Item1 || _directions[_dirIdx].Item2 != targetDir.Item2)
            {
                TurnRight(robot);
            }

            while (_currentCell.Item1 != back.Item1 || _currentCell.Item2 != back.Item2)
            {
                Move(robot);
            }

        } while (stack.Count > 0);
    }

    private readonly (int, int)[] _directions = { (0, 1), (-1, 0), (0, -1), (1, 0) };
    private int _dirIdx;
    private (int, int) _currentCell;

    private void TurnLeft(Robot robot)
    {
        _dirIdx++;
        _dirIdx %= _directions.Length;
        robot.TurnLeft();
    }

    private void TurnRight(Robot robot)
    {
        _dirIdx += _directions.Length;
        _dirIdx--;
        _dirIdx %= _directions.Length;
        robot.TurnRight();
    }

    private bool Move(Robot robot)
    {
        if (robot.Move())
        {
            _currentCell.Item1 += _directions[_dirIdx].Item1;
            _currentCell.Item2 += _directions[_dirIdx].Item2;
            return true;
        }

        return false;
    }

    private bool Clean(Robot robot, ISet<(int, int)> cleanedCells)
    {
        if (cleanedCells.Add(_currentCell))
        {
            robot.Clean();
            return true;
        }

        return false;
    }
}
