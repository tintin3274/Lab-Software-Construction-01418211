public class Network {
    private String isp;
    private String ip;

    public Network(String isp, String ip) {
        this.isp = isp;
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "Network{" +
                "isp='" + isp + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
