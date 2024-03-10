import java.util.Objects;

public class Client {
    private String name;
    private String startTime;
    private String endTime;
    private ClientType clientType;

    public Client(String name, String startTime, String endTime, ClientType clientType) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.clientType = clientType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    @Override
    public String toString() {
        return "Client{name='" + name + "', startTime=" + startTime + ", endTime=" + endTime + ", clientType=" + clientType + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Client otherClient = (Client) o;

        return Objects.equals(name, otherClient.name) &&
                Objects.equals(startTime, otherClient.startTime) &&
                Objects.equals(endTime, otherClient.endTime) &&
                Objects.equals(clientType, otherClient.clientType);
    }
}