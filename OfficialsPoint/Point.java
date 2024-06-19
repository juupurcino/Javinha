public class Point {
    
    private Long cpfOfficial;
    private int dayPoint;
    private int monthPoint;
    private int yearPoint;
    private int hourPoint;
    private int minutePoint;

    public Point(Official official, int dayPoint, int monthPoint, int yearPoint, int hourPoint, int minutePoint){

        this.cpfOfficial = official.getCpf();
        this.dayPoint = dayPoint;
        this.monthPoint = monthPoint;
        this.yearPoint = yearPoint;
        this.hourPoint = hourPoint;
        this.minutePoint = minutePoint;
        
    }
}
