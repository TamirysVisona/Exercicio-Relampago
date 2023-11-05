import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TurmaTest {

    @Test
    void deveMatricularAluno() {
        Aluno aluno = new Aluno(new Curso());
        Turma turma = new Turma(new Disciplina("Disciplina"));
        turma.matricular(aluno);
        assertEquals(1, turma.getNumeroAlunos());
        assertTrue(turma.verificarMatricula(aluno));
    }

    @Test
    void deveDesmatricularAluno() {
        Aluno aluno = new Aluno(new Curso());
        Turma turma = new Turma(new Disciplina("Disciplina"));
        turma.matricular(aluno);
        turma.desmatricular(aluno);
        assertEquals(0, turma.getNumeroAlunos());
        assertFalse(turma.verificarMatricula(aluno));
    }

    @Test
    void deveMatricularDoisAlunos() {
        Aluno aluno1 = new Aluno(new Curso());
        Aluno aluno2 = new Aluno(new Curso());
        Turma turma = new Turma(new Disciplina("Disciplina"));
        turma.matricular(aluno1);
        turma.matricular(aluno2);
        assertEquals(2, turma.getNumeroAlunos());
    }

    @Test
    void deveRetornarNomeProfessor(){
        Turma turma = new Turma(new Disciplina("Disciplina"));
        Professor professor = new Professor();
        professor.setNome("Marco");
        turma.setProfessor(professor);
        assertEquals("Marco", turma.nomeProfessor());
    }

    @Test
    void deveRetornarTurmaSemProfessor(){
        Turma turma = new Turma(new Disciplina("Disciplina"));
        try {
            turma.nomeProfessor();
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("Turma sem professor", e.getMessage());
        }

    }

    @Test
    void deveRetornarListaAlunos(){
        Aluno aluno1 = new Aluno(new Curso());
        Aluno aluno2 = new Aluno(new Curso());
        Turma turma = new Turma(new Disciplina("Disciplina"));
        turma.matricular(aluno1);
        turma.matricular(aluno2);
        ArrayList<String> alunos = turma.listaAlunosTurma();
        assertEquals(alunos, turma.listaAlunosTurma());
    }
}