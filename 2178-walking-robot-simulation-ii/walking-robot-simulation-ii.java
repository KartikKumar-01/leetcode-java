class Robot {

    int w, h;
    int x, y;
    int dir; 
    int perimeter;

    public Robot(int width, int height) {
        w = width;
        h = height;
        x = 0;
        y = 0;
        dir = 0;
        perimeter = 2 * (w + h - 2);
    }

    public void step(int num) {

        num = num % perimeter;

        if (num == 0) {
            if (x == 0 && y == 0) dir = 3;
            return;
        }

        while (num-- > 0) {

            if (dir == 0) { 
                if (x + 1 < w) x++;
                else {
                    dir = 1;
                    y++;
                }
            }
            else if (dir == 1) { 
                if (y + 1 < h) y++;
                else {
                    dir = 2;
                    x--;
                }
            }
            else if (dir == 2) { 
                if (x - 1 >= 0) x--;
                else {
                    dir = 3;
                    y--;
                }
            }
            else { 
                if (y - 1 >= 0) y--;
                else {
                    dir = 0;
                    x++;
                }
            }
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        if (dir == 0) return "East";
        if (dir == 1) return "North";
        if (dir == 2) return "West";
        return "South";
    }
}