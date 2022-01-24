package com.tqtplayer.severlet;

import com.tqtplayer.DAO.ISongDAO;
import com.tqtplayer.DAO.SongDAO;
import com.tqtplayer.model.Song;
import com.tqtplayer.utils.InfoSong;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.nio.file.Paths;
import java.util.List;

@WebServlet(name = "ServletSong", value = "/song")
@MultipartConfig
public class ServletSong extends HttpServlet {
    private ISongDAO songService;
    public static final int DEFAULT_BUFFER_SIZE = 8192;
    private static final String MUSIC_ROOT_FOLDER = "E:\\Case-Module4\\src\\main\\webapp\\resources\\archives\\music\\";
    private static final String LOGO_ROOT_FOLDER = "E:\\Case-Module4\\src\\main\\webapp\\resources\\archives\\logo\\";

    public void init() {
        songService = new SongDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html/charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "musicmanager":
                listMusic(request, response);
                break;

        }
    }


    private void listMusic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             List<Song> songList = songService.selectAllSong();
             System.out.println(songList);
             request.setAttribute("listSong", songList);
             RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/admin/musicmanager.jsp");
             dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html/charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "upNewSong":
                insertSong(request, response);
                break;
//            case "editSong":
//                try {
//                    editSong(request, response);
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                break;
//            case "deleteSong":
//                try {
//                    deleteSong(request, response);
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                break;
        }
    }

//    private void deleteSong(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("deleteid"));
//        songService.deleteSong(id);
//        listMusic(request,response);
//    }

//    private void editSong(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
//        String songName = request.getParameter("inputEditSongname");
//        String singerName = request.getParameter("inputEditSingerName");
//        int songId = Integer.parseInt(request.getParameter("editId"));
//        String status = request.getParameter("statusselect");
//        System.out.println(status);
//        Song song = new Song(songId, songName, singerName, status);
//        songService.updateSong(song);
//        listMusic(request, response);
//    }
//

    private void insertSong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part songPath = request.getPart("songFile");
        Part logoPath = request.getPart("logoFile");
        String songFileName = Paths.get(songPath.getSubmittedFileName()).getFileName().toString();
        String logoFileName = Paths.get(logoPath.getSubmittedFileName()).getFileName().toString();
        try {
            File mp3File = new File(MUSIC_ROOT_FOLDER + songFileName);
            mp3File.createNewFile();
            File logoFile = new File(LOGO_ROOT_FOLDER + logoFileName);
            logoFile.createNewFile();
            int read;
            byte[] bytes = new byte[DEFAULT_BUFFER_SIZE];

            FileOutputStream outputStreamMp3 = new FileOutputStream(mp3File, false);
            InputStream isMp3 = songPath.getInputStream();
            while ((read = isMp3.read(bytes)) != -1) {
                outputStreamMp3.write(bytes, 0, read);
            }

            byte[] byteslogo = new byte[DEFAULT_BUFFER_SIZE];
            InputStream isLogo = logoPath.getInputStream();
            FileOutputStream outputStreamLogo = new FileOutputStream(logoFile, false);
            while ((read = isLogo.read(byteslogo)) != -1) {
                outputStreamLogo.write(byteslogo, 0, read);
            }
            isMp3.close();
            isLogo.close();
            outputStreamMp3.close();
            outputStreamLogo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String absoluteSongPath = MUSIC_ROOT_FOLDER + songFileName;
        String absoluteLogoPath = "resources\\archives\\logo\\" + logoFileName;
        List<String> infoSong = InfoSong.get(absoluteSongPath);
        String songPaths = "resources\\archives\\music\\" + songFileName;
        String songTitle = infoSong.get(0);
        String singerName = infoSong.get(1);
        boolean deleted = false;
        long countListens = 0;
        Song newSong = new Song(songTitle, singerName, songPaths, absoluteLogoPath, false, countListens);
        System.out.println(newSong);
        songService.insertSong(newSong);
        listMusic(request, response);
    }
}
