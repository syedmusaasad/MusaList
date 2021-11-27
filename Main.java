public class Main {
    public static void main(String[] args) {
        MusaList array = new MusaList(5, 3, 1, 5);
    }
}

class MusaList {
    private int size;
    private int main[];
    private int special;
    
    public MusaList(int ...provided) {
        this.size = provided.length;
        this.main = provided;
        if (this.size != 0) this.special = provided[0];
        else this.special = Integer.MAX_VALUE;
        for (int i = 0; i < this.size; i++) specialCheck(this.main[i]);
    }
    
    public void add(int num) {
        if (size == 0) this.special = num; else specialCheck(num);
        int temp[] = new int[this.size + 1];
        for (int i = 0; i < this.size; i++) temp[i] = this.main[i];
        temp[this.size] = num;
        this.main = temp;
        this.size++;
    }
    
    public void remove(int i) {
        try {
            this.get(i);
            int temp[] = new int[this.size - 1];
            int shift = 0;
            for (int j = 0; j < temp.length; j++) {
                if (j != i) temp[j] = this.main[j + shift];
                else temp[j] = this.main[j + ++shift];
                if (j == 0) this.special = temp[0];
                specialCheck(temp[j]);
            }
            this.main = temp;
            this.size--;
            if (size == 0) this.special = Integer.MAX_VALUE;
        } catch (Exception e) {
            // throw new NullPointerException();
        }
    }
    
    public int get(int i) {
        return (i >= 0 && i < this.size) ? this.main[i] : null;
    }
    
    public int getSize() {
        return this.size;
    }
    
    public int getSpecial() {
        return this.special;
    }
    
    private void specialCheck(int num) {
        if (num > this.special) this.special = num;
    }
    
    public String toString() {
        String string = "{ ";
        for (int i = 0; i < this.size; i++)
            if (i == this.size - 1) string += this.main[i];
            else string += this.main[i] + ", ";
        string += " }";
        return string;
    }
}