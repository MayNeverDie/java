package vector;

import static java.lang.Math.*;

public class Vector {
    private int vectorSize;
    private double[] values;

    public Vector(int vectorSize, double... values) {
        this.vectorSize = vectorSize;
        this.values = values;
    }

    public double[] getValues() {
        return values;
    }

    public void setValues(double[] values) {
        this.values = values;
    }

    public int getVectorSize() {
        return vectorSize;
    }

    public void setVectorSize(int vectorSize) {
        this.vectorSize = vectorSize;
    }

    public double fastPower(int base, int exp) {
        if (exp == 0) return 1;
        if (exp % 2 == 0) return fastPower(base * base, exp / 2);
        return base * fastPower(base, exp - 1);
    }

    public double euclideanNorm() {
        double sum = 0;
        for (double element : values) {
            sum += fastPower((int) element, 2);
        }
        return sqrt(sum);
    }

    public double maxValue() {
        double max = values[0];
        for (int i = 1; i < vectorSize; i++) {
            if (values[i] > max) max = values[i];
        }
        return max;
    }

    public double minValue() {
        double min = values[0];
        for (int i = 1; i < vectorSize; i++) {
            if (values[i] < min) min = values[i];
        }
        return min;
    }

    public void mulByANum(double num) {
        double[] newValues = new double[vectorSize];
        int i = 0;
        for (double element : values) {
            element *= num;
            newValues[i] = element;
            i++;
        }
        setValues(newValues);
    }

    public void quickSort(double[] arr, int lowIndex, int highIndex) {
        int i = lowIndex;
        int j = highIndex;
        int middleIndex = lowIndex + (highIndex - lowIndex) / 2;
        double pivot = arr[middleIndex];
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                double temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            i++;
            j--;
        }
        if (lowIndex < j) {
            quickSort(arr, lowIndex, j);
        }

        if (highIndex > i) {
            quickSort(arr, highIndex, i);
        }
    }

    public void add(double[] vector1, double[] vector2) {
        if (vector1.length != vector2.length) return;
        double[] res = new double[vector1.length];
        for (int i = 0; i < vectorSize; i++) {
            res[i] += vector1[i] + vector2[i];
        }
        setValues(res);
    }

    public void scalar(double[] vector1, double[] vector2) {
        if (vector1.length != vector2.length) return;
        double[] res = new double[vector1.length];
        for (int i = 0; i < vectorSize; i++) {
            res[i] += vector1[i] * vector2[i];
        }
        setValues(res);
    }
}





