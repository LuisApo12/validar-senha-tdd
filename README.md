# Validação de entrada por senha (TDD em Java)

Função que valida uma senha e retorna um `ResultadoValidacao` com:

- `isValido()`: `true` se a senha atende todas as regras
- `getErros()`: lista com todos os erros encontrados (múltiplos erros são retornados juntos)

## Regras

| Regra | Mensagem de erro |
|---|---|
| Mínimo de 8 caracteres | A senha deve ter pelo menos 8 caracteres |
| Mínimo de 2 dígitos | A senha deve conter pelo menos 2 dígitos |
| Ao menos 1 letra maiúscula | A senha deve conter pelo menos uma letra maiuscula |
| Ao menos 1 caractere especial | A senha deve conter pelo menos um caractere especial |

Exemplo: `"mypass"` retorna os 4 erros acima.

## Estrutura

```
src/main/java/com/gqs/aula/tdd/
    ResultadoValidacao.java
    ValidadorSenha.java
src/test/java/com/gqs/aula/tdd/
    ValidadorSenhaTest.java
```

## Como rodar os testes

No VS Code / Codespace, use o ícone de **Testing** (frasquinho) na barra lateral.
Ou, no terminal:

```bash
mvn test
```

## Ciclos de TDD aplicados

1. Mínimo de 8 caracteres (RED, GREEN)
2. Senha válida (teste de regressão)
3. Mínimo de 2 dígitos (RED, GREEN)
4. Letra maiúscula (RED, GREEN)
5. Caractere especial (RED, GREEN)
6. Múltiplos erros com `"mypass"`
7. REFACTOR: constantes para mensagens e limites

---

## Como subir este projeto no GitHub

### Opção A: tudo de uma vez

1. No GitHub, crie um repositório **Public** (com ou sem README).
2. No terminal, dentro da pasta do projeto:

```bash
git init
git add -A
git commit -m "Validacao de senha com TDD"
git branch -M main
git remote add origin https://github.com/SEU_USUARIO/NOME_DO_REPOSITORIO.git
git push -u origin main
```

### Opção B: mostrando o ciclo TDD no histórico (recomendado)

Se o professor confere o histórico de commits (RED antes de GREEN), crie os arquivos aos poucos
e faça um commit a cada fase, no padrão:

```
Senha Ciclo 1 - RED: senha curta
Senha Ciclo 1 - GREEN: valida tamanho
Senha Ciclo 3 - RED: poucos digitos
Senha Ciclo 3 - GREEN: valida digitos
...
Senha Ciclo 7 - REFACTOR: constantes e metodo mais legivel
```

A cada fase: `git add -A`, `git commit -m "mensagem"` e `git push`.

> Dica: teste o link do repositório numa janela anônima. Se aparecer 404, ele está privado.
