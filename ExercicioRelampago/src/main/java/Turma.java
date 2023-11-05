import java.util.ArrayList;
public class Turma {
    private Disciplina disciplina;
    private ArrayList<Aluno> alunos;
    private Professor professor;

    public Turma(Disciplina disciplina) {
        this.alunos = new ArrayList<Aluno>();
        this.setDisciplina(disciplina);
        this.setProfessor(professor);
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        if (disciplina == null) {
            throw new IllegalArgumentException("Disciplina invalida");
        }
        this.disciplina = disciplina;
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

    public int getNumeroAlunos() {
        return this.alunos.size();
    }

    public Professor getProfessor() {
        return this.professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String nomeProfessor(){
        if(this.professor == null){
            throw new IllegalArgumentException("Turma sem professor");
        }
        return this.professor.getNome();
    }

    public ArrayList<String> listaAlunosTurma(){
        ArrayList<String> nomesAlunos = new ArrayList<>();

        for(Aluno aluno : this.alunos){
            nomesAlunos.add(aluno.getNome());
        }

        return nomesAlunos;
    }

}
