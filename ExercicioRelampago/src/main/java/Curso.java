import java.util.ArrayList;


public class Curso {
    private String nome;
    private Professor coordenador;

    private ArrayList<Aluno> alunos;
    private ArrayList<Turma> turmas;

    public Curso(){
        this.alunos = new ArrayList<>();
        this.turmas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Professor coordenador) {
        this.coordenador = coordenador;
    }

    public String getNomeCoordenador() {
        if (this.coordenador == null) {
            throw new NullPointerException("Curso sem coordenador");
        }
        return this.coordenador.getNome();
    }

    public void matricular(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public void desmatricular(Aluno aluno) {
        this.alunos.remove(aluno);
    }

    public boolean verificarMatricula(Aluno aluno) {
        return this.alunos.contains(aluno);
    }

    public ArrayList<String> listaAlunosCurso(){
        ArrayList<String> nomesAlunos = new ArrayList<>();

        for(Aluno aluno : this.alunos){
            nomesAlunos.add(aluno.getNome());
        }

        return nomesAlunos;
    }

    public void cadastrarTurma(Turma turma){
        this.turmas.add(turma);
    }

    public void excluirTurma(Turma turma){
        this.turmas.remove(turma);
    }

    public ArrayList<Turma> turmasCadastradas(){
        return this.turmas;
    }

    public boolean verificarTurma(Turma turma){
        return this.turmas.contains(turma);
    }

    public ArrayList<String> listaProfessoresTurma(){
        ArrayList<String> listaProfessores = new ArrayList<String>();

        for (Turma turma : this.turmas){
            if(!turma.nomeProfessor().equals("Turma sem professor")){
                listaProfessores.add(turma.nomeProfessor());
            }
        }

        return listaProfessores;
    }


    public ArrayList<String> listaAlunosTurma(){
        ArrayList<String> listaAlunos = new ArrayList<String>();

        for(Aluno aluno : this.alunos){
            for (Turma turma : this.turmas){
                if(turma.verificarMatricula(aluno)){
                    listaAlunos.add(aluno.getNome());
                }
            }
        }

        return listaAlunos;
    }

    public ArrayList<String> listaDisciplinasTurma(){
        ArrayList<String> listaDisciplinas = new ArrayList<String>();

        for (Turma turma : this.turmas){
                listaDisciplinas.add(turma.getDisciplina().getNome());
        }

        return listaDisciplinas;
    }
}
