package cn.edu.cqu.greenewsbeta01;

public class NewsCard {
    private String title;
    //    private int imageID;
    private String imagePath;
    //    public NewsCard(String title,int imageID){
//        this.title=title;
//        this.imageID=imageID;
//    }
    public NewsCard(String title,String imagePath){
        this.title=title;
        this.imagePath=imagePath;
    }

    public String getTitle(){
        return title;
    }
    public String imagePath(){
        return imagePath;
    }
}
