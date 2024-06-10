ppackage dao;

import conexao.Conexao;
import model.Emprestimo;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmprestimoDAOimpl {

    private final Conexao connectionBD;
    private static final Logger LOGGER = Logger.getLogger(EmprestimoDAOimpl.class.getName());

    public EmprestimoDAOimpl() {
        this.connectionBD = new Conexao();
    }

    public int pegaMaiorID() {
        int maior = 0;
        String sql = "SELECT MAX(id_emprestimo) as id_emprestimo FROM emprestimo";
        try (Connection conexaoBD = Conexao.getConnection(); Statement stmt = conexaoBD.createStatement(); ResultSet res = stmt.executeQuery(sql)) {
            if (res.next()) {
                maior = res.getInt("id_emprestimo");
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao pegar maior ID", ex);
        }
        return maior;
    }

    public ArrayList<Emprestimo> getMinhaLista() {
        ArrayList<Emprestimo> lista = new ArrayList<>();
        String sql = "SELECT * FROM emprestimo";
        try (Connection conexaoBD = Conexao.getConnection(); Statement stmt = conexaoBD.createStatement(); ResultSet resposta = stmt.executeQuery(sql)) {
            while (resposta.next()) {
                int id = resposta.getInt("id_emprestimo");
                String nomeAmigo = resposta.getString("nome_amigo");
                String nomeFerramenta = resposta.getString("nome_ferramenta");
                Date dataEmprestimo = resposta.getDate("data_emprestimo");
                Date dataDevolucao = resposta.getDate("data_devolucao");
                boolean status = resposta.getBoolean("status");

                Emprestimo objeto = new Emprestimo(id, nomeAmigo, nomeFerramenta, dataEmprestimo, dataDevolucao, status);
                lista.add(objeto);
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao obter lista de empréstimos", ex);
        }
        return lista;
    }

    public boolean inserirEmprestimoBD(Emprestimo objeto) {
        String sql = "INSERT INTO emprestimo(nome_amigo, nome_ferramenta, data_emprestimo, data_devolucao, status) VALUES(?, ?, ?, ?, ?)";
        try (Connection conexaoBD = Conexao.getConnection(); PreparedStatement stmt = conexaoBD.prepareStatement(sql)) {
            stmt.setString(1, objeto.getNomeAmigo());
            stmt.setString(2, objeto.getNomeFerramenta());
            stmt.setDate(3, new java.sql.Date(objeto.getDataEmprestimo().getTime()));
            stmt.setDate(4, new java.sql.Date(objeto.getDataDevolucao().getTime()));
            stmt.setBoolean(5, objeto.getStatus());
            stmt.executeUpdate();
            return true;
        } catch (SQLException erro) {
            LOGGER.log(Level.SEVERE, "Erro ao inserir empréstimo", erro);
        }
        return false;
    }

    public boolean deleteEmprestimoBD(int id) {
        String sql = "DELETE FROM emprestimo WHERE id_emprestimo = ?";
        try (Connection conexaoBD = Conexao.getConnection(); PreparedStatement stmt = conexaoBD.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException erro) {
            LOGGER.log(Level.SEVERE, "Erro ao deletar empréstimo", erro);
        }
        return false;
    }

    public boolean updateEmprestimoBD(Emprestimo objeto) {
        String sql = "UPDATE emprestimo SET nome_amigo = ?, nome_ferramenta = ?, data_emprestimo = ?, data_devolucao = ?, status = ? WHERE id_emprestimo = ?";
        try (Connection conexaoBD = Conexao.getConnection(); PreparedStatement stmt = conexaoBD.prepareStatement(sql)) {
            stmt.setString(1, objeto.getNomeAmigo());
            stmt.setString(2, objeto.getNomeFerramenta());
            stmt.setDate(3, new java.sql.Date(objeto.getDataEmprestimo().getTime()));
            stmt.setDate(4, new java.sql.Date(objeto.getDataDevolucao().getTime()));
            stmt.setBoolean(5, objeto.getStatus());
            stmt.setInt(6, objeto.getId());
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException erro) {
            LOGGER.log(Level.SEVERE, "Erro ao atualizar empréstimo", erro);
        }
        return false;
    }

    public Emprestimo carregaEmprestimoBD(int id) {
        String sql = "SELECT * FROM emprestimo WHERE id_emprestimo = ?";
        try (Connection conexaoBD = Conexao.getConnection(); PreparedStatement stmt = conexaoBD.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet resposta = stmt.executeQuery()) {
                if (resposta.next()) {
                    int emprestimoId = resposta.getInt("id_emprestimo");
                    String nomeAmigo = resposta.getString("nome_amigo");
                    String nomeFerramenta = resposta.getString("nome_ferramenta");
                    Date dataEmprestimo = resposta.getDate("data_emprestimo");
                    Date dataDevolucao = resposta.getDate("data_devolucao");
                    boolean status = resposta.getBoolean("status");
                    return new Emprestimo(emprestimoId, nomeAmigo, nomeFerramenta, dataEmprestimo, dataDevolucao, status);
                }
            }
        } catch (SQLException erro) {
            LOGGER.log(Level.SEVERE, "Erro ao carregar empréstimo", erro);
        }
        return null;
    }
}
