/*
 * The MIT License (MIT)
 * 
 * Copyright (c) 2014 Alexander Polden
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
 */

package com.tehforce.sofa;

import java.io.File;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration(); //light weight java game library
		cfg.title = "sofa";
        cfg.width = 1000;
		cfg.height = 1000;
		
		if(args.length == 1){
			if(args[0].matches("help")){
				System.out.println("Scripted Offline Battle Arena v0.2");
				System.out.println("Written by Alexander Polden <mockillo@gmail.com>");
				System.exit(0);
			}
			
			if(args[0].matches("about")){
				System.out.println("TBW! :-(");
				System.exit(0);
			}
		}
		
		if(args.length != 2){
			System.out.println("Scripted Offline Battle Arena v0.2");
			System.out.println("Usage: java -jar sofa.jar <team one's sofascript> <team two's sofascript>");
			System.out.println("For syntax help: java -jar sofa.jar help");
			System.out.println("For more info: java -jar sofa.jar about");
			System.exit(1);
		}
			
		System.out.println("Team one is red, team two is blue!");
		System.out.println("Good luck to you all!");
		
		File leftTeam = new File(args[0]);
		File rightTeam = new File(args[1]);

		new LwjglApplication(new GameMain(leftTeam, rightTeam), cfg);
	}
}