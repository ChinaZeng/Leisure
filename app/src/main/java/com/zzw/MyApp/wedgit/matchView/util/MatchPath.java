package com.zzw.MyApp.wedgit.matchView.util;

import android.util.SparseArray;

import java.util.ArrayList;

public class MatchPath {

    private static final SparseArray<float[]> sPointList;

    public static final char V_LEFT = '#';
    public static final char H_TOP_BOTTOM = '$';
    public static final char V_RIGHT = '%';


    static {
        sPointList = new SparseArray<float[]>();
        float[][] LETTERS = new float[][]{
                new float[]{
                        // A
                        24, 0, 1, 22,
                        1, 22, 1, 72,
                        24, 0, 47, 22,
                        47, 22, 47, 72,
                        1, 48, 47, 48
                },

                new float[]{
                        // B
                        0, 0, 0, 72,
                        0, 0, 37, 0,
                        37, 0, 47, 11,
                        47, 11, 47, 26,
                        47, 26, 38, 36,
                        38, 36, 0, 36,
                        38, 36, 47, 46,
                        47, 46, 47, 61,
                        47, 61, 38, 71,
                        37, 72, 0, 72,
                },

                new float[]{
                        // C
                        47, 0, 0, 0,
                        0, 0, 0, 72,
                        0, 72, 47, 72,
                },

                new float[]{
                        // D
                        0, 0, 0, 72,
                        0, 0, 24, 0,
                        24, 0, 47, 22,
                        47, 22, 47, 48,
                        47, 48, 23, 72,
                        23, 72, 0, 72,
                },

                new float[]{
                        // E
                        0, 0, 0, 72,
                        0, 0, 47, 0,
                        0, 36, 37, 36,
                        0, 72, 47, 72,
                },

                new float[]{
                        // F
                        0, 0, 0, 72,
                        0, 0, 47, 0,
                        0, 36, 37, 36,
                },

                new float[]{
                        // G
                        47, 23, 47, 0,
                        47, 0, 0, 0,
                        0, 0, 0, 72,
                        0, 72, 47, 72,
                        47, 72, 47, 48,
                        47, 48, 24, 48,
                },

                new float[]{
                        // H
                        0, 0, 0, 72,
                        0, 36, 47, 36,
                        47, 0, 47, 72,
                },

                new float[]{
                        // I
                        0, 0, 47, 0,
                        24, 0, 24, 72,
                        0, 72, 47, 72,
                },

                new float[]{
                        // J
                        47, 0, 47, 72,
                        47, 72, 24, 72,
                        24, 72, 0, 48,
                },

                new float[]{
                        // K
                        0, 0, 0, 72,
                        47, 0, 3, 33,
                        3, 38, 47, 72,
                },

                new float[]{
                        // L
                        0, 0, 0, 72,
                        0, 72, 47, 72,
                },

                new float[]{
                        // M
                        0, 0, 0, 72,
                        0, 0, 24, 23,
                        24, 23, 47, 0,
                        47, 0, 47, 72,
                },

                new float[]{
                        // N
                        0, 0, 0, 72,
                        0, 0, 47, 72,
                        47, 72, 47, 0,
                },

                new float[]{
                        // O
                        0, 0, 0, 72,
                        0, 72, 47, 72,
                        47, 72, 47, 0,
                        47, 0, 0, 0,
                },

                new float[]{
                        // P
                        0, 0, 0, 72,
                        0, 0, 47, 0,
                        47, 0, 47, 36,
                        47, 36, 0, 36,
                },

                new float[]{
                        // Q
                        0, 0, 0, 72,
                        0, 72, 23, 72,
                        23, 72, 47, 48,
                        47, 48, 47, 0,
                        47, 0, 0, 0,
                        24, 28, 47, 71,
                },

                new float[]{
                        // R
                        0, 0, 0, 72,
                        0, 0, 47, 0,
                        47, 0, 47, 36,
                        47, 36, 0, 36,
                        0, 37, 47, 72,
                },

                new float[]{
                        // S
                        47, 0, 0, 0,
                        0, 0, 0, 36,
                        0, 36, 47, 36,
                        47, 36, 47, 72,
                        47, 72, 0, 72,
                },

                new float[]{
                        // T
                        0, 0, 47, 0,
                        24, 0, 24, 72,
                },

                new float[]{
                        // U
                        0, 0, 0, 72,
                        0, 72, 47, 72,
                        47, 72, 47, 0,
                },

                new float[]{
                        // V
                        0, 0, 24, 72,
                        24, 72, 47, 0,
                },

                new float[]{
                        // W
                        0, 0, 0, 72,
                        0, 72, 24, 49,
                        24, 49, 47, 72,
                        47, 72, 47, 0
                },

                new float[]{
                        // X
                        0, 0, 47, 72,
                        47, 0, 0, 72
                },

                new float[]{
                        // Y
                        0, 0, 24, 23,
                        47, 0, 24, 23,
                        24, 23, 24, 72
                },

                new float[]{
                        // Z
                        0, 0, 47, 0,
                        47, 0, 0, 72,
                        0, 72, 47, 72
                },
        };
        final float[][] NUMBERS = new float[][]{
                new float[]{
                        // 0
                        0, 0, 0, 72,
                        0, 72, 47, 72,
                        47, 72, 47, 0,
                        47, 0, 0, 0,
                },
                new float[]{
                        // 1
                        24, 0, 24, 72,
                },

                new float[]{
                        // 2
                        0, 0, 47, 0,
                        47, 0, 47, 36,
                        47, 36, 0, 36,
                        0, 36, 0, 72,
                        0, 72, 47, 72
                },

                new float[]{
                        // 3
                        0, 0, 47, 0,
                        47, 0, 47, 36,
                        47, 36, 0, 36,
                        47, 36, 47, 72,
                        47, 72, 0, 72,
                },

                new float[]{
                        // 4
                        0, 0, 0, 36,
                        0, 36, 47, 36,
                        47, 0, 47, 72,
                },

                new float[]{
                        // 5
                        0, 0, 0, 36,
                        0, 36, 47, 36,
                        47, 36, 47, 72,
                        47, 72, 0, 72,
                        0, 0, 47, 0
                },

                new float[]{
                        // 6
                        0, 0, 0, 72,
                        0, 72, 47, 72,
                        47, 72, 47, 36,
                        47, 36, 0, 36
                },

                new float[]{
                        // 7
                        0, 0, 47, 0,
                        47, 0, 47, 72
                },

                new float[]{
                        // 8
                        0, 0, 0, 72,
                        0, 72, 47, 72,
                        47, 72, 47, 0,
                        47, 0, 0, 0,
                        0, 36, 47, 36
                },

                new float[]{
                        // 9
                        47, 0, 0, 0,
                        0, 0, 0, 36,
                        0, 36, 47, 36,
                        47, 0, 47, 72,
                }
        };
        // A - Z
        for (int i = 0; i < LETTERS.length; i++) {
            sPointList.append(i + 65, LETTERS[i]);
        }
        // a - z
        for (int i = 0; i < LETTERS.length; i++) {
            sPointList.append(i + 65 + 32, LETTERS[i]);
        }
        // 0 - 9
        for (int i = 0; i < NUMBERS.length; i++) {
            sPointList.append(i + 48, NUMBERS[i]);
        }
        // blank
        addChar(' ', new float[]{});
        // -
        addChar('-', new float[]{
                0, 36, 47, 36
        });
        // .
        addChar('.', new float[]{
                24, 60, 24, 72
        });

        addChar('/', new float[]{
                24, 0, 0, 72
        });

        addChar('闲', new float[]{
                0, 0, 0, 72,
                12, 0, 18, 0,
                26, 0, 72, 0,
                72, 0, 72, 72,
                72, 72, 65, 65,
                16, 36, 56, 36,
                36, 16, 36, 66,
                36, 36, 10, 60,
                36, 36, 56, 56
        });

        addChar('暇', new float[]{
                0, 0, 0, 62,
                0, 5, 20, 3,
                20, 2, 20, 60,
                0, 30, 20, 28,
                0, 62, 20, 60,

                24, 0, 24, 72,
                24, 4, 44, 2,
                44, 0, 44, 28,
                24, 28, 44, 28,

                22, 36, 44, 36,
                22, 48, 42, 45,

                52, 2, 72, 2,
                72, 0, 72, 20,
                52, 20, 72, 20,

                52, 36, 72, 36,
                72, 36, 40, 72,
                52, 36, 72, 72

        });

        addChar(V_LEFT, new float[]{
                -12, 120, -12, 38,
                -12, 38, -12, -45
        });
        addChar(H_TOP_BOTTOM, new float[]{
                0, -45, 23, -45,
                23, -45, 67, -45,
                0, 120, 23, 120,
                23, 120, 67, 120
        });
        addChar(V_RIGHT, new float[]{
                79, -45, 79, 38,
                79, 38, 79, 120
        });
    }

    public static void addChar(char c, float[] points) {
        sPointList.append(c, points);
    }

    public static ArrayList<float[]> getPath(String str) {
        return getPath(str, 1, 14);
    }

    public static boolean isButtonModle;

    /**
     * @param str
     * @param scale
     * @param gapBetweenLetter
     * @return ArrayList of float[] {x1, y1, x2, y2}
     */
    public static ArrayList<float[]> getPath(String str, float scale, int gapBetweenLetter) {
        ArrayList<float[]> list = new ArrayList<float[]>();
        float offsetForWidth = 0;
        for (int i = 0; i < str.length(); i++) {
            int pos = str.charAt(i);
            int key = sPointList.indexOfKey(pos);
            if (key == -1) {
                continue;
            }
            float[] points = sPointList.get(pos);

            if (isButtonModle) {
                float[] points1 = new float[points.length + 16];
                for (int j = 0; j < sPointList.get(H_TOP_BOTTOM).length; j++) {
                    points1[j] = sPointList.get(H_TOP_BOTTOM)[j];
                }
                for (int j = 0; j < points.length; j++) {
                    points1[j + 16] = points[j];
                }
                points = points1;
            }

            int pointCount = points.length / 4;
            for (int j = 0; j < pointCount; j++) {
                float[] line = new float[4];
                for (int k = 0; k < 4; k++) {
                    float l = points[j * 4 + k];
                    // x
                    if (k % 2 == 0) {
                        line[k] = (l + offsetForWidth) * scale;
                    }
                    // y
                    else {
                        line[k] = l * scale;
                    }
                }
                list.add(line);
            }
            offsetForWidth += 57 + gapBetweenLetter;
        }

        if (isButtonModle) {
            isButtonModle = false;
        }
        return list;
    }
}
