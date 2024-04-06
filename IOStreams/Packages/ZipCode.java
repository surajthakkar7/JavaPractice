package Packages;

public class ZipCode {
    public String zip;
    public double distance;
    public String city;
    public String state;

    @Override
    public String toString(){
        return "ZipCode{" + "zip='" + zip + '\'' + ", distance= " + distance +   ", city='" + city + '\''  + ", state='" + state + '\'' + "}";
    }
}
