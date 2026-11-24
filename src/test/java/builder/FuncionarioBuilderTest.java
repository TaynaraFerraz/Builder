package builder;

import org.example.Funcionario;
import org.example.FuncionarioBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioBuilderTest {

    @Test
    void deveRetornarExcecaoParaFuncionarioSemRegistro() {
        try {
            FuncionarioBuilder funcionarioBuilder = new FuncionarioBuilder();
            Funcionario funcionario = funcionarioBuilder
                    .setNome("Funcionario 1")
                    .setEmail("funcionario1@email.com")
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Registro inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaFuncionarioSemNome() {
        try {
            FuncionarioBuilder funcionarioBuilder = new FuncionarioBuilder();
            Funcionario funcionario = funcionarioBuilder
                    .setRegistro(1)
                    .setEmail("funcionario1@email.com")
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nome inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarFuncionarioValido() {
        FuncionarioBuilder funcionarioBuilder = new FuncionarioBuilder();
        Funcionario funcionario = funcionarioBuilder
                .setRegistro(1)
                .setNome("Funcionario 1")
                .setEmail("funcionario1@email.com")
                .build();

        assertNotNull(funcionario);
    }
}
