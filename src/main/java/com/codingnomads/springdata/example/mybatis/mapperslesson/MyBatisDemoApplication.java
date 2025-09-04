/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.mybatis.mapperslesson;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyBatisDemoApplication {

    /* Before running this app, be sure to:

       * create a new empty schema in the mysql database named "mybatis"

       * execute the SQL found "songs_table.sql" on the mybatis schema

       * update the "spring.datasource.url" property in your application.properties file to
         jdbc:mysql://localhost:3306/mybatis?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC

    */

    public static void main(String[] args) {
        SpringApplication.run(MyBatisDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadInitialData(SongMapper songMapper) {
        return (args) -> {
            Song song1 = new Song();
            song1.setName("Minnesota, WI");
            song1.setAlbum_name("Bon Iver");
            song1.setArtist_name("Bon Iver");
            song1.setSong_length(232);

            Song song2 = new Song();
            song2.setName("Post Humorous");
            song2.setAlbum_name("Orca");
            song2.setArtist_name("Gus Dapperton");
            song2.setSong_length(279);

            Song song3 = new Song();
            song3.setName("Blown Away");
            song3.setAlbum_name("Blown Away");
            song3.setArtist_name("Carrie Underwood");
            song3.setSong_length(440);

            Song song4 = new Song();
            song4.setName("Dance The Night");
            song4.setAlbum_name("Barbie The Album");
            song4.setArtist_name("Carrie Underwood");
            song4.setSong_length(339);

            Song song5 = new Song();
            song5.setName("Pay Phone");
            song5.setAlbum_name("Overexposed");
            song5.setArtist_name("Marroon 5");
            song5.setSong_length(230);

            Song song7 = new Song();
            song7.setName("Blinding Lights");
            song7.setAlbum_name("After Hours");
            song7.setArtist_name("The Weeknd");
            song7.setSong_length(200);

            Song song8 = new Song();
            song8.setName("Rolling in the Deep");
            song8.setAlbum_name("21");
            song8.setArtist_name("Adele");
            song8.setSong_length(228);

            Song song10 = new Song();
            song10.setName("Radioactive");
            song10.setAlbum_name("Night Visions");
            song10.setArtist_name("Imagine Dragons");
            song10.setSong_length(186);

            Song songUpdater = new Song();
            songUpdater.setId(2L);
            songUpdater.setName("Love Is Wicked");
            songUpdater.setAlbum_name("Love Is Wicked");
            songUpdater.setArtist_name("Brick and Lace");
            songUpdater.setSong_length(321);


//            Methods usage

            songMapper.insertNewSong(song1);
            songMapper.insertNewSong(song2);
            songMapper.insertNewSong(song3);
            songMapper.insertNewSong(song4);
            songMapper.insertNewSong(song5);
            songMapper.insertNewSong(song7);
            songMapper.insertNewSong(song8);
            songMapper.insertNewSong(song10);


            Song getById = songMapper.getSongById(1L);
            System.out.println(getById.toString());

            List<Song> longSongs = songMapper.getSongsWithLengthGreaterThan(250);
            longSongs.forEach(System.out::println);

            List<Song> albumName = songMapper.getSongsByAlbumName("Night Visions");
            albumName.forEach(System.out::println);

            List<Song> artistAndLength = songMapper.getSongsByArtistNameAndLengthLessThan("The Weekend", 300);
            artistAndLength.forEach(System.out::println);

            List<Song> getByName = songMapper.getSongsByName("Pay Phone");
            getByName.forEach(System.out::println);

            List<Song> getByAlbumAndArtis = songMapper.getSongsByAlbumAndArtist("Maroon 5", "Overexposed");
            getByAlbumAndArtis.forEach(System.out::println);

            List<Song> getByArtis = songMapper.getSongsByArtist("Maroon 5");
            getByArtis.forEach(System.out::println);

//            This mapper updates an existing song.
            songMapper.updateSong(songUpdater);

            songMapper.deleteSongById(4L);

            songMapper.deleteSongsByAlbumAndArtist("Adele", "21");
        };
    }
}
