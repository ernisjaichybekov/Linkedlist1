package model;

public class Actor {

    private String actorFullName;
    private String role;

    public Actor(String actorFullName, String role) {
        this.actorFullName = actorFullName;
        this.role = role;
    }

    public String getActorFullName() {
        return actorFullName;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "\nActor{" +
                "\nactorFullName='" + actorFullName + '\'' +
                ",\n role='" + role + '\'' +
                '}';
    }

}
