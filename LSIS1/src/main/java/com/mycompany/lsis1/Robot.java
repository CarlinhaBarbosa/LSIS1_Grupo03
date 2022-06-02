

public class Robot {
    private String idRobot;
    private int idComp;
    private int idEquipa;
    private String nome;
    private double tempo;
    private double velocidade;

    private static final int INT_DEFAULT = 0;
    private static final String STRING_DEFAULT ="n/d";
    private static final double DOUBLE_DEFAULT= 0.0;

    public Robot(){
        this.id = STRING_DEFAULT;
        this.idComp = INT_DEFAULT;
        this.idEquipa = INT_DEFAULT;
        this.nome = STRING_DEFAULT;
        this.tempo = DOUBLE_DEFAULT;
        this.velocidade = DOUBLE_DEFAULT;
    }

    public Robot(String idRobot, int idComp, int idEquipa, String nome, double tempo, double velocidade) {
        this.idRobot = idRobot;
        this.idComp = idComp;
        this.idEquipa = idEquipa;
        this.nome = nome;
        this.tempo = tempo;
        this.velocidade = velocidade;
    }

    public Robot(Robot robot){
        this.idRobot = robot.idRobot;
        this.idComp = robot.idComp;
        this.idEquipa = robot.idEquipa;
        this.nome = robot.nome;
        this.tempo = robot.tempo;
        this.velocidade = robot.velocidade;
    }

    public String getIdRobot() {
        return idRobot;
    }

    public int getIdComp() {
        return idComp;
    }

    public int getIdEquipa() {
        return idEquipa;
    }

    public String getNome() {
        return nome;
    }

    public double getTempo() {
        return tempo;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setIdRobot(String idRobot) {
        this.idRobot = idRobot;
    }

    public void setIdComp(int idComp) {
        this.idComp = idComp;
    }

    public void setIdEquipa(int idEquipa) {
        this.idEquipa = idEquipa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Robot{" +
                "idRobot='" + idRobot + '\'' +
                ", idComp=" + idComp +
                ", idEquipa=" + idEquipa +
                ", nome='" + nome + '\'' +
                ", tempo=" + tempo +
                ", velocidade=" + velocidade +
                '}';
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Robot)) return false;
        if (!super.equals(object)) return false;
        Robot robot = (Robot) object;
        return idComp == robot.idComp && idEquipa == robot.idEquipa && java.lang.Double.compare(robot.tempo, tempo) == 0 && java.lang.Double.compare(robot.velocidade, velocidade) == 0 && java.util.Objects.equals(idRobot, robot.idRobot) && java.util.Objects.equals(nome, robot.nome);
    }
}
