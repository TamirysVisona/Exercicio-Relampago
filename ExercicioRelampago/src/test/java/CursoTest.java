import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CursoTest {

    @Test
    void deveRetornarNomeCoordenador() {
        Professor coordenador = new Professor();
        coordenador.setNome("Ana");
        Curso curso = new Curso();
        curso.setCoordenador(coordenador);
        assertEquals("Ana", curso.getNomeCoordenador());
    }

    @Test
    void deveVerificarCursoSemCoordenador() {
        try {
            Curso curso = new Curso();
            curso.getNomeCoordenador();
            fail();
        }
        catch (NullPointerException e) {
            assertEquals("Curso sem coordenador", e.getMessage());
        }

    }

    @Test
    void deveMatricularEVerificarAluno() {
        Curso curso = new Curso();
        Aluno aluno = new Aluno(curso);
        curso.matricular(aluno);
        assertTrue(curso.verificarMatricula(aluno));
    }

    @Test
    void deveDesmatricularEVerificarAlunoFalso() {
        Curso curso = new Curso();
        Aluno aluno = new Aluno(curso);
        curso.matricular(aluno);
        curso.desmatricular(aluno);
        assertFalse(curso.verificarMatricula(aluno));
    }

    @Test
    void deveRetornarListaAlunos(){
        Curso curso = new Curso();
        Aluno aluno1 = new Aluno(curso);
        Aluno aluno2 = new Aluno(curso);
        curso.matricular(aluno1);
        curso.matricular(aluno2);
        ArrayList<String> alunos = curso.listaAlunosCurso();
        assertEquals(alunos, curso.listaAlunosCurso());
    }

    @Test
    void deveRetornarListaProfessores(){
        Professor professor1 = new Professor();
        Professor professor2 = new Professor();
        professor1.setNome("Marco");
        professor2.setNome("Caniato");

        Turma turma1 = new Turma(new Disciplina("Disciplina"));
        Turma turma2 = new Turma(new Disciplina("Disciplina"));
        turma1.setProfessor(professor1);
        turma2.setProfessor(professor2);

        Curso curso = new Curso();
        curso.cadastrarTurma(turma1);
        curso.cadastrarTurma(turma2);

        ArrayList<String> professores = curso.listaProfessoresTurma();
        assertEquals(professores, curso.listaProfessoresTurma());
        assertEquals(2, curso.listaProfessoresTurma().size());
    }

    @Test
    void deveRetornarListaAlunosTurmas(){
        Curso curso = new Curso();

        Aluno aluno1 = new Aluno(curso);
        Aluno aluno2 = new Aluno(curso);
        aluno1.setNome("Ana");
        aluno2.setNome("João");

        curso.matricular(aluno1);
        curso.matricular(aluno2);

        Turma turma1 = new Turma(new Disciplina("Disciplina"));
        Turma turma2 = new Turma(new Disciplina("Disciplina"));
        turma1.matricular(aluno1);
        turma2.matricular(aluno2);

        curso.cadastrarTurma(turma1);
        curso.cadastrarTurma(turma2);

        ArrayList<String> alunos = curso.listaAlunosTurma();
        assertEquals(alunos, curso.listaAlunosTurma());
        assertEquals(2, curso.listaAlunosTurma().size());
    }

    @Test
    void deveCadastrarTurmaERetornarTrue(){
        Curso curso = new Curso();
        Turma turma = new Turma(new Disciplina("Disciplina"));
        curso.cadastrarTurma(turma);
        assertTrue(curso.verificarTurma(turma));
    }

    @Test
    void deveDescadastrarTurmaERetornarFalse(){
        Curso curso = new Curso();
        Turma turma = new Turma(new Disciplina("Disciplina"));
        curso.cadastrarTurma(turma);
        curso.excluirTurma(turma);
        assertFalse(curso.verificarTurma(turma));
    }

    @Test
    void deveRetornarListaDisciplinasCurso() {
        Curso curso = new Curso();

        Disciplina disciplina1 = new Disciplina("Orientacao a Objetos");
        Disciplina disciplina2 = new Disciplina("Estrutura de Dados");

        Turma turma1 = new Turma(disciplina1);
        Turma turma2 = new Turma(disciplina2);

        curso.cadastrarTurma(turma1);
        curso.cadastrarTurma(turma2);

        ArrayList<String> disciplinas = curso.listaDisciplinasTurma();
        assertEquals(disciplinas, curso.listaDisciplinasTurma());
        assertEquals(2, curso.listaDisciplinasTurma().size());
    }

}