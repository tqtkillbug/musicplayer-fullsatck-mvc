package com.tqtplayer.utils;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class InfoSong {
    public static List<String> get(String fileLocation) {
        List<String> infoSong = new ArrayList<>();
        try {
            InputStream input = new FileInputStream(fileLocation);
            ContentHandler handler = new DefaultHandler();
            Metadata metadata = new Metadata();
            Parser parser = new Mp3Parser();
            ParseContext parseCtx = new ParseContext();
            parser.parse(input, handler, metadata, parseCtx);
            input.close();
            String titleSong = metadata.get("dc:title");
            String artistName = metadata.get("xmpDM:artist");
            infoSong.add(titleSong);
            infoSong.add(artistName);
        } catch (IOException | SAXException | TikaException e) {
            e.printStackTrace();
        }
        return infoSong;
    }



}
