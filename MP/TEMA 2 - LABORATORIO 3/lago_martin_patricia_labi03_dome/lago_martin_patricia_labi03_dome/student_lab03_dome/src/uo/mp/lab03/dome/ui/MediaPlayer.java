package uo.mp.lab03.dome.ui;

import uo.mp.lab03.dome.model.Cd;
import uo.mp.lab03.dome.model.Dvd;
import uo.mp.lab03.dome.model.Item;
import uo.mp.lab03.dome.model.Videogame;
import uo.mp.lab03.dome.model.Videogame.Platform;
import uo.mp.lab03.dome.service.MediaLibrary;

public class MediaPlayer {

    public void run() {
	MediaLibrary ml = new MediaLibrary();
	// CD
	String theTitle = "Come Together";
	String theArtist = "Beatles";
	int theTime = 70;
	int theTracks = 4;
	// DVD
	String theTitle_DVD = "The fantastic Mr. Fox";
	String theDirector = "Wes Anderson";
	int duration_film = 120;
	// Videogame
	String theTitle_VIDEOGAME = "The Last Of Us";
	String theAuthor = "Naughty dog";
	Platform platform = Platform.XBOX;

	Item cd = new Cd(theTitle, theArtist, theTracks, theTime);
	Dvd dvd = new Dvd(theTitle_DVD, theDirector, duration_film);
	Videogame videogame = new Videogame(theTitle_VIDEOGAME, theAuthor, platform);

	ml.add(cd);
	ml.add(dvd);
	ml.add(videogame);

	System.out.println("-----responsables-----");
	System.out.println(ml.getResponsibles());
	System.out.println("-----Catalogue-----");
//	System.out.println(ml.list(null));
    }
}
