package com.xpcf.algorithm;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.*;

/**
 * stream 只需要关闭最外层的
 * @author XPCF
 * @version 1.0
 * @date 5/14/2021 2:44 AM
 */
public class SearchTimu {
    public static void main(String[] args) throws Exception {
        Map<String, String> map = readFromRepository();
        Scanner scanner = new Scanner(System.in);
        String s;
        while ((s = scanner.nextLine()) != null) {
            System.out.println(map.get(s));
        }
    }

    /**
     *
     * 持久化map
     * @param map
     * @throws IOException
     */
    public static void writeInRep(Map<String, String> map) throws IOException {

        if (map == null) {
            map = parseHtml();
        }
//        FileReader fileReader = new FileReader("res/questions.rep");
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        String firstLine = bufferedReader.readLine();

        FileWriter fileWriter = new FileWriter("res/questions.rep", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//        if (firstLine != "" && fileReader != null) {
//            fileReader
//        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            bufferedWriter.write(entry.getKey());
            bufferedWriter.write("  ");
            bufferedWriter.write(entry.getValue());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    /**
     * 从持久化文件从read为map
     * @return
     * @throws IOException
     */
    public static Map<String, String> readFromRepository() throws IOException {
        FileReader fileReader = new FileReader("res/questions.rep");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Map<String, String> map = new HashMap<>();
        String curLine;
        while ((curLine = bufferedReader.readLine()) != null &&  curLine != "") {
            String[] s = curLine.split("  ");
            map.put(s[0], s[1]);
        }
        bufferedReader.close();
        return map;
    }

    /**
     * 根据html 解析出title ——> answer的map
     * @return
     * @throws IOException
     */
    public static Map<String, String> parseHtml() throws IOException {
        FileReader fileReader = new FileReader("res/temp.html");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            sb.append(s).append("\n");
        }
        bufferedReader.close();


        Document doc = Jsoup.parse(sb.toString());
        Elements answers = doc.select("div.Py_answer");
        Elements forms = doc.select("form");
        forms.remove(0);
        Elements allTitles = doc.select("div.Cy_TItle");
        List<String> titleList = new ArrayList<>();
        for (Element titleEle : allTitles) {
            String title = titleEle.select("div").eq(1).select("div").first().text();
            titleList.add(title.replaceAll("（\\d\\.\\d分）", ""));
        }

//        sb.setLength(0);
        List<Integer> ansList = new ArrayList<>();
        for (Element answer : answers) {
            char choice = answer.select("span").first().select("span").toString().charAt(13);
            // TODO optimize
//            sb.append(choice - 'A').append(" ");
            ansList.add(choice - 'A');
        }

        List<String> ansStrList = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            String ans = forms.get(i).select("li").get(ansList.get(i)).select("a").first().text();
            ansStrList.add(ans);
        }

        Map<String, String> resMap = new HashMap<>();
        for (int i = 0; i < titleList.size(); i++) {
            resMap.put(titleList.get(i), ansStrList.get(i));
        }
        return resMap;
    }
}
