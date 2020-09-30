package de.wartbar.view.basic;

import de.wartbar.common.WartbarBase;

public class CSS extends WartbarBase {

	// https://leaverou.github.io/css3patterns/#honeycomb
	public static String honeycombBackground() {
		return
						"        background:" +
						"        radial-gradient(circle farthest-side at 0% 50%,#fb1 23.5%,rgba(240,166,17,0) 0)21px 30px," +
						"        radial-gradient(circle farthest-side at 0% 50%,#B71 24%,rgba(240,166,17,0) 0)19px 30px," +
						"        linear-gradient(#fb1 14%,rgba(240,166,17,0) 0, rgba(240,166,17,0) 85%,#fb1 0)0 0," +
						"        linear-gradient(150deg,#fb1 24%,#B71 0,#B71 26%,rgba(240,166,17,0) 0,rgba(240,166,17,0) 74%,#B71 0,#B71 76%,#fb1 0)0 0," +
						"        linear-gradient(30deg,#fb1 24%,#B71 0,#B71 26%,rgba(240,166,17,0) 0,rgba(240,166,17,0) 74%,#B71 0,#B71 76%,#fb1 0)0 0," +
						"        linear-gradient(90deg,#B71 2%,#fb1 0,#fb1 98%,#B71 0%)0 0 #fb1;" +
						"        background-size: 40px 60px;";
	}

	// https://leaverou.github.io/css3patterns/#diagonal-checkerboard
	public static String diagonalCheckerboardBackground() {
		return
						"        background-color: #eee;" +
						"        background-image: linear-gradient(45deg, black 25%, transparent 25%, transparent 75%, black 75%, black)," +
						"        linear-gradient(-45deg, black 25%, transparent 25%, transparent 75%, black 75%, black);" +
						"        background-size: 60px 60px;";
	}

	// https://leaverou.github.io/css3patterns/#blueprint-grid
	public static String blueprintGridBackground() {
		return
						"        background-color:#269;" +
										"        background-image: linear-gradient(white 2px, transparent 2px)," +
										"        linear-gradient(90deg, white 2px, transparent 2px)," +
										"        linear-gradient(rgba(255,255,255,.3) 1px, transparent 1px)," +
										"        linear-gradient(90deg, rgba(255,255,255,.3) 1px, transparent 1px);" +
										"        background-size: 100px 100px, 100px 100px, 20px 20px, 20px 20px;" +
										"        background-position:-2px -2px, -2px -2px, -1px -1px, -1px -1px;";
	}

	public static String redprintGridBackground() {
		return
						"        background-color:#a22a1a;" +
										"        background-image: linear-gradient(white 2px, transparent 2px)," +
										"        linear-gradient(90deg, white 2px, transparent 2px)," +
										"        linear-gradient(rgba(255,255,255,.3) 1px, transparent 1px)," +
										"        linear-gradient(90deg, rgba(255,255,255,.3) 1px, transparent 1px);" +
										"        background-size: 100px 100px, 100px 100px, 20px 20px, 20px 20px;" +
										"        background-position:-2px -2px, -2px -2px, -1px -1px, -1px -1px;";
	}

	public static String greenprintGridBackground() {
		return
						"        background-color:#35791b;" +
										"        background-image: linear-gradient(white 2px, transparent 2px)," +
										"        linear-gradient(90deg, white 2px, transparent 2px)," +
										"        linear-gradient(rgba(255,255,255,.3) 1px, transparent 1px)," +
										"        linear-gradient(90deg, rgba(255,255,255,.3) 1px, transparent 1px);" +
										"        background-size: 100px 100px, 100px 100px, 20px 20px, 20px 20px;" +
										"        background-position:-2px -2px, -2px -2px, -1px -1px, -1px -1px;";
	}

	public static String blackprintGridBackground() {
		return
						"        background-color:#000000;" +
										"        background-image: linear-gradient(white 2px, transparent 2px)," +
										"        linear-gradient(90deg, white 2px, transparent 2px)," +
										"        linear-gradient(rgba(255,255,255,.3) 1px, transparent 1px)," +
										"        linear-gradient(90deg, rgba(255,255,255,.3) 1px, transparent 1px);" +
										"        background-size: 100px 100px, 100px 100px, 20px 20px, 20px 20px;" +
										"        background-position:-2px -2px, -2px -2px, -1px -1px, -1px -1px;";
	}

	public static String darkgreyprintGridBackground() {
		return
						"        background-color:#333333;" +
										"        background-image: linear-gradient(white 2px, transparent 2px)," +
										"        linear-gradient(90deg, white 2px, transparent 2px)," +
										"        linear-gradient(rgba(255,255,255,.3) 1px, transparent 1px)," +
										"        linear-gradient(90deg, rgba(255,255,255,.3) 1px, transparent 1px);" +
										"        background-size: 100px 100px, 100px 100px, 20px 20px, 20px 20px;" +
										"        background-position:-2px -2px, -2px -2px, -1px -1px, -1px -1px;";
	}

	public static String getOuterBackground(int number) {
		switch (number) {
			default:
			case 1: return blueprintGridBackground();
			case 2: return honeycombBackground();
			case 3: return diagonalCheckerboardBackground();
			case 4: return redprintGridBackground();
			case 5: return greenprintGridBackground();
			case 6: return blackprintGridBackground();
			case 7: return darkgreyprintGridBackground();
		}
	}

	public static String getTableClass(int tableClass) {
		String tableClassString =
						"table.tableclass" +
										tableClass +
										" { background: #";
		switch (tableClass) {
			case 1: // red
				tableClassString += "FF0000";
				break;
			case 2: // dark green
				tableClassString += "004400";
				break;
			case 3: // blue
				tableClassString += "0000FF";
				break;
			case 4: // dark green
				tableClassString += "006400";
				break;
			case 5: // dark orange
				tableClassString += "EE7C00";
				break;
			case 6: // dim grey
				tableClassString += "696969";
				break;
			case 7: // fire brick
				tableClassString += "B22222";
				break;
			case 8: // forest green
				tableClassString += "228B22";
				break;
			case 9: // cyan
				tableClassString += "2F6F6F";
				break;
			case 10: // indigo
				tableClassString += "4B0082";
				break;
			case 11: // midnight blue
				tableClassString += "191970";
				break;
			case 12: // orange red
				tableClassString += "FF4500";
				break;
			case 13: // deep pink
				tableClassString += "FF1493";
				break;
			case 14: // slate grey
				tableClassString += "708090";
				break;
			case 15: // teal
				tableClassString += "008080";
				break;
			default: // black
			case 16:
				tableClassString += "000000";
				break;
		}

		tableClassString += "; }" + nl;
		return tableClassString;
	}

	public static int getValidTableClass(int tableClass) {
		if ((tableClass<1) || (tableClass>16)) {
			return 16;
		} else
			return  tableClass;
	}
}
