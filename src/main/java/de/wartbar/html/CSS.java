package de.wartbar.html;

import de.wartbar.common.WartbarBase;
import de.wartbar.common.WartbarProperties;

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

	public static String getBackgroundByProperty() {
		switch (props.getBackgroundId()) {
			default:
			case 1: return blueprintGridBackground();
			case 2: return honeycombBackground();
			case 3: return diagonalCheckerboardBackground();
		}
	}
}
