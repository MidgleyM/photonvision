package com.chameleonvision.classabstraction.pipeline.pipes;

import org.apache.commons.lang3.tuple.Pair;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;

public class FindContoursPipe implements Pipe<Mat, List<MatOfPoint>> {

    private List<MatOfPoint> foundContours = new ArrayList<>();

    public FindContoursPipe() {}

    @Override
    public Pair<List<MatOfPoint>, Long> run(Mat input) {
        long processStartNanos = System.nanoTime();

        Imgproc.findContours(input, foundContours, new Mat(), Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_TC89_L1);

        long processTime = processStartNanos - System.nanoTime();
        return Pair.of(foundContours, processTime);
    }
}
