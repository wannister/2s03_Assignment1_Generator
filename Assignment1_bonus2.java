/*This class is for creating the assignment java files for students to analyze and fix.
 * Author: wang yang
 * Revised Date: 10/10/2016
 * */
package Assignment_1_bonus2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

class Assignment1_bonus2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("./read.txt")); // get
																				// student
																				// number
		String line;
		String[] a = new String[1500];
		int i = 0, f;
		while ((line = in.readLine()) != null) {
			a[i] = line;
			i++;
			// System.out.println(line);
		}

		in.close();

		for (f = 0; f < 250; f++) {
			if (a[f] != null) { // create folder for each student

				File dir = new File(a[f]);
				dir.mkdir();
				File dir2 = new File(a[f] + "/" + "2s03");
				dir2.mkdir();
				PrintWriter A1 = new PrintWriter(a[f] + "/" + "2s03" + "/" + "A1.java", "UTF-8");
				PrintWriter A2 = new PrintWriter(a[f] + "/" + "2s03" + "/" + "A2.java", "UTF-8");
				PrintWriter A3 = new PrintWriter(a[f] + "/" + "2s03" + "/" + "A3.java", "UTF-8");
				PrintWriter A1Test = new PrintWriter(a[f] + "/" + "A1Test.java", "UTF-8");
				PrintWriter A2Test = new PrintWriter(a[f] + "/" + "A2Test.java", "UTF-8");
				PrintWriter A3Test = new PrintWriter(a[f] + "/" + "A3Test.java", "UTF-8");
				PrintWriter A1csv = new PrintWriter(a[f] + "/" + "A1.csv", "UTF-8");
				PrintWriter A2csv = new PrintWriter(a[f] + "/" + "A2.csv", "UTF-8");
				PrintWriter A3csv = new PrintWriter(a[f] + "/" + "A3.csv", "UTF-8");

				Random rand = new Random(); // A3 is easier, so I wrote for it
											// first.
				int n[] = new int[20];
				int x = rand.nextInt(10) - 5, y = rand.nextInt(10) - 5;//get the random number 
				n[0] = rand.nextInt(5);
				n[1] = rand.nextInt(5);
				for (i = 2; i < 20; i++) {
					n[i] = x * n[i - 2] + y * n[i - 1];

				}

				A3.println("package cs2s03;\n" + " public class A3 {\n" + "  public int Rec(int n) {\n"
						+ "     int a0 = " + n[0] + ", a1 = " + n[1] + ", an = 0 ;\n" + "    int x = " + x + ", y = "
						+ y + " ;\n" + "    if ( n == 0 ) return a0;\n" + "   if ( n == 1 ) return a1;\n"
						+ "    for ( int i=2; i <= n; i++ ) {\n" + "       an= x * a0 + y * a1;\n" + "      a0 = a1;\n"
						+ "      a1 = an;\n" + "    }\n" + "     return an;\n" + "  }\n" + " }\n");

				A3.close();

				A3Test.println("import static org.junit.Assert.*;\n" + " import org.junit.BeforeClass;\n"
						+ " import org.junit.Test;\n" + " import cs2s03.A3;\n" + " public class A3Test {\n"
						+ "   private static A3 tester;\n" + "  @BeforeClass\n" + " public static void setUp(){\n"
						+ "     tester = new A3();\n" + "  } \n" + "  @Test\n" + "  public void RecTest() {\n");
				for (i = 1; i < 20; i++) {
					A3Test.print("assertEquals(\"Rec(" + i + ") must be " + n[i] + "\"," + n[i] + ", tester.Rec(" + i
							+ "));\r");

				}
				A3Test.println("	  }" + "		}");

				A3Test.close();

				for (i = 1; i < 20; i++) {
					A3csv.print(i + "," + n[i] + "\n");

				}
				A3csv.close();

				// Start of the A1

				int value[] = new int[8];
				{ // define the random value of 8 pieces cut from the original
					// cube, which was done in the following steps
					for (i = 0; i < 8; i++) {
						value[i] = rand.nextInt(30) - 15;
						// System.out.println(value[i]);
					}

					int center[] = new int[3]; // define the center of the cube
					int boundary[] = new int[6];

					for (i = 0; i < 3; i++) {
						center[i] = rand.nextInt(10) - 5;
						// System.out.println(center[i]);
					}
					for (i = 0; i < 6; i++) { // define the boundary extended
												// from the center, which cut
												// the cube into 8 pieces
						boundary[i] = center[i / 2] + rand.nextInt(10) - 5;
						// System.out.println(boundary[i]);
					}

					int data[][] = new int[400][4]; // get the coordinate data
													// for all points
					for (i = 0; i < 50; i++) {
						data[i][0] = rand.nextInt(100 + boundary[0]) - 100;
						data[i][1] = rand.nextInt(100 + boundary[2]) - 100;
						data[i][2] = rand.nextInt(100 + boundary[4]) - 100;
						data[i][3] = value[0];
					}
					for (i = 50; i < 100; i++) {
						data[i][0] = rand.nextInt(100 + boundary[0]) - 100;
						data[i][1] = rand.nextInt(100 - boundary[3]) + boundary[3];
						data[i][2] = rand.nextInt(100 + boundary[4]) - 100;
						data[i][3] = value[1];
					}
					for (i = 100; i < 150; i++) {
						data[i][0] = rand.nextInt(100 + boundary[0]) - 100;
						data[i][1] = rand.nextInt(100 + boundary[2]) - 100;
						data[i][2] = rand.nextInt(100 - boundary[5]) + boundary[5];
						data[i][3] = value[2];
					}
					for (i = 150; i < 200; i++) {
						data[i][0] = rand.nextInt(100 + boundary[0]) - 100;
						data[i][1] = rand.nextInt(100 - boundary[3]) + boundary[3];
						data[i][2] = rand.nextInt(100 - boundary[5]) + boundary[5];
						data[i][3] = value[3];
					}
					for (i = 200; i < 250; i++) {
						data[i][0] = rand.nextInt(100 - boundary[1]) + boundary[1];
						data[i][1] = rand.nextInt(100 + boundary[2]) - 100;
						data[i][2] = rand.nextInt(100 + boundary[4]) - 100;
						data[i][3] = value[4];
					}
					for (i = 250; i < 300; i++) {
						data[i][0] = rand.nextInt(100 - boundary[1]) + boundary[1];
						data[i][1] = rand.nextInt(100 + boundary[2]) - 100;
						data[i][2] = rand.nextInt(100 - boundary[5]) + boundary[5];
						data[i][3] = value[5];
					}
					for (i = 300; i < 350; i++) {
						data[i][0] = rand.nextInt(100 - boundary[1]) + boundary[1];
						data[i][1] = rand.nextInt(100 - boundary[3]) + boundary[3];
						data[i][2] = rand.nextInt(100 + boundary[4]) - 100;
						data[i][3] = value[6];
					}
					for (i = 350; i < 400; i++) {
						data[i][0] = rand.nextInt(100 - boundary[1]) + boundary[1];
						data[i][1] = rand.nextInt(100 - boundary[3]) + boundary[3];
						data[i][2] = rand.nextInt(100 - boundary[5]) + boundary[5];
						data[i][3] = value[7];
					}

					for (i = 0; i < 400; i++) // random the variable order
					{
						int j, transfer;
						int k = rand.nextInt(399);
						for (j = 0; j < 4; j++) {
							transfer = data[i][j];
							data[i][j] = data[k][j];
							data[k][j] = transfer;
						}
						// System.out.println(data[i][0]+" "+data[i][1]+"
						// "+data[i][2]+" "+data[i][3]+"\r\n");
					}

					A1.println("package cs2s03;\n" // write A1
							+ "public class A1 {\n" + "	public int cases(int v, int u, int w) {	\n" + "   	if (v <= "
							+ boundary[0] + "){ \n" + "          if (u <= " + boundary[2] + "){ \n"
							+ "             if (w <= " + boundary[4] + "){\n" + "                return " + value[0]
							+ ";\n" + "           } else {\n" + "               return " + value[2] + ";\n"
							+ "          }\n" + "     } else { \n" + "        if (w <= " + boundary[5] + "){\n"
							+ "           return " + value[1] + ";\n" + "      } else {\n" + "         return "
							+ value[3] + ";\n" + "    }\n" + "      }\n" + " } else { \n" + "    if (w <= "
							+ boundary[4] + "){ \n" + "       if (u <= " + boundary[1] + "){\n" + "          return "
							+ value[4] + ";\n" + "     } else {\n" + "        return " + value[6] + ";\n" + "   }\n"
							+ " } else { \n" + "    if (u <= " + boundary[2] + "){\n" + "    return " + value[5] + ";\n"
							+ "  } else {\n" + "     return " + value[7] + ";\n" + "   }\n" + "  }\n" + "   }\n"
							+ "	}\n" + "	}\n");
					A1.close();

					A1Test.println("import static org.junit.Assert.*;\n" + "import org.junit.BeforeClass;\n"
							+ "import org.junit.Test;\n" + "import cs2s03.A1;\n" + "public class A1Test {\n"
							+ "  private static A1 tester;\n" + " @BeforeClass\n" + " public static void setUp(){\n"
							+ "    tester = new A1();\n" + " }\n" + "@Test\n" + "public void casesTest() {\n");
					for (i = 0; i < 400; i++) {
						A1Test.print("assertEquals(\"cases(" + data[i][0] + "," + data[i][1] + "," + data[i][2]
								+ ") must be " + data[i][3] + "\"," + data[i][3] + ", tester.cases(" + data[i][0] + ","
								+ data[i][1] + "," + data[i][2] + "));\r"

						);
					}
					A1Test.println("}\n" + "}\n");
					A1Test.close();

					for (i = 0; i < 400; i++) {
						A1csv.print(data[i][0] + ",");
						A1csv.print(data[i][1] + ",");
						A1csv.print(data[i][2] + ",");
						A1csv.print(data[i][3] + "\n");

					}
					A1csv.close();

				}

				// Start of A2. Since all the numbers will be randomized during
				// every loop, I did the loop similar to A1 and apply the result
				// to A2.

				{ // define the random value of 8 pieces cut from the original
					// cube, which was done in the following steps
					for (i = 0; i < 8; i++) {
						value[i] = rand.nextInt(30) - 15;
						// System.out.println(value[i]);
					}

					int center[] = new int[3]; // define the center of the cube
					int boundary[] = new int[6];

					for (i = 0; i < 3; i++) {
						center[i] = rand.nextInt(10) - 5;
						// System.out.println(center[i]);
					}
					for (i = 0; i < 6; i++) { // define the boundary extended
												// from the center, which cut
												// the cube into 8 pieces
						boundary[i] = center[i / 2] + rand.nextInt(10) - 5;
						// System.out.println(boundary[i]);
					}

					int data[][] = new int[400][4];
					for (i = 0; i < 50; i++) {
						data[i][0] = rand.nextInt(100 + boundary[0]) - 100;
						data[i][1] = rand.nextInt(100 + boundary[2]) - 100;
						data[i][2] = rand.nextInt(100 + boundary[4]) - 100;
						data[i][3] = value[0];
					}
					for (i = 50; i < 100; i++) {
						data[i][0] = rand.nextInt(100 + boundary[0]) - 100;
						data[i][1] = rand.nextInt(100 - boundary[3]) + boundary[3];
						data[i][2] = rand.nextInt(100 + boundary[4]) - 100;
						data[i][3] = value[1];
					}
					for (i = 100; i < 150; i++) {
						data[i][0] = rand.nextInt(100 + boundary[0]) - 100;
						data[i][1] = rand.nextInt(100 + boundary[2]) - 100;
						data[i][2] = rand.nextInt(100 - boundary[5]) + boundary[5];
						data[i][3] = value[2];
					}
					for (i = 150; i < 200; i++) {
						data[i][0] = rand.nextInt(100 + boundary[0]) - 100;
						data[i][1] = rand.nextInt(100 - boundary[3]) + boundary[3];
						data[i][2] = rand.nextInt(100 - boundary[5]) + boundary[5];
						data[i][3] = value[3];
					}
					for (i = 200; i < 250; i++) {
						data[i][0] = rand.nextInt(100 - boundary[1]) + boundary[1];
						data[i][1] = rand.nextInt(100 + boundary[2]) - 100;
						data[i][2] = rand.nextInt(100 + boundary[4]) - 100;
						data[i][3] = value[4];
					}
					for (i = 250; i < 300; i++) {
						data[i][0] = rand.nextInt(100 - boundary[1]) + boundary[1];
						data[i][1] = rand.nextInt(100 + boundary[2]) - 100;
						data[i][2] = rand.nextInt(100 - boundary[5]) + boundary[5];
						data[i][3] = value[5];
					}
					for (i = 300; i < 350; i++) {
						data[i][0] = rand.nextInt(100 - boundary[1]) + boundary[1];
						data[i][1] = rand.nextInt(100 - boundary[3]) + boundary[3];
						data[i][2] = rand.nextInt(100 + boundary[4]) - 100;
						data[i][3] = value[6];
					}
					for (i = 350; i < 400; i++) {
						data[i][0] = rand.nextInt(100 - boundary[1]) + boundary[1];
						data[i][1] = rand.nextInt(100 - boundary[3]) + boundary[3];
						data[i][2] = rand.nextInt(100 - boundary[5]) + boundary[5];
						data[i][3] = value[7];
					}

					for (i = 0; i < 400; i++) // random the variable order
					{
						int j, transfer;
						int k = rand.nextInt(399);
						for (j = 0; j < 4; j++) {
							transfer = data[i][j];
							data[i][j] = data[k][j];
							data[k][j] = transfer;
						}
						// System.out.println(data[i][0]+" "+data[i][1]+"
						// "+data[i][2]+" "+data[i][3]+"\r\n");
					}

					A2.println("package cs2s03;\n" // write A2
							+ "public class A2 {\n" + "	public int cases(int v, int u, int w) {	\n" + "   	if (v <= "
							+ boundary[0] + "){ \n" + "          if (u <= " + boundary[2] + "){ \n"
							+ "             if (w <= " + boundary[4] + "){\n" + "                return " + value[0]
							+ ";\n" + "           } else {\n" + "               return " + value[2] + ";\n"
							+ "          }\n" + "     } else { \n" + "        if (w <= " + boundary[5] + "){\n"
							+ "           return " + value[1] + ";\n" + "      } else {\n" + "         return "
							+ value[3] + ";\n" + "    }\n" + "      }\n" + " } else { \n" + "    if (w <= "
							+ boundary[4] + "){ \n" + "       if (u <= " + boundary[1] + "){\n" + "          return "
							+ value[4] + ";\n" + "     } else {\n" + "        return " + value[6] + ";\n" + "   }\n"
							+ " } else { \n" + "    if (u <= " + boundary[2] + "){\n" + "    return " + value[5] + ";\n"
							+ "  } else {\n" + "     return " + value[7] + ";\n" + "   }\n" + "  }\n" + "   }\n"
							+ "	}\n" + "	}\n");
					A2.close();

					A2Test.println("import static org.junit.Assert.*;\n" + "import org.junit.BeforeClass;\n"
							+ "import org.junit.Test;\n" + "import cs2s03.A2;\n" + "public class A2Test {\n"
							+ "  private static A2 tester;\n" + " @BeforeClass\n" + " public static void setUp(){\n"
							+ "    tester = new A2();\n" + " }\n" + "@Test\n" + "public void casesTest() {\n");
					for (i = 0; i < 400; i++) {
						A2Test.print("assertEquals(\"cases(" + data[i][0] + "," + data[i][1] + "," + data[i][2]
								+ ") must be " + data[i][3] + "\"," + data[i][3] + ", tester.cases(" + data[i][0] + ","
								+ data[i][1] + "," + data[i][2] + "));\r"

						);
					}
					A2Test.println("}\n" + "}\n");
					A2Test.close();

					for (i = 0; i < 400; i++) {
						A2csv.print(data[i][0] + "," + data[i][1] + "," + data[i][2] + "," + data[i][3] + "\n");

					}
					A2csv.close();

				}

			}

		}

	}
}
