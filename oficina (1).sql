-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 07/06/2025 às 13:15
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `oficina`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `clientes`
--

CREATE TABLE `clientes` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `telefone` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `empresas`
--

CREATE TABLE `empresas` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `telefone` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `ordens_servico`
--

CREATE TABLE `ordens_servico` (
  `cliente_id` int(11) NOT NULL,
  `peca_id` int(11) NOT NULL,
  `cliente_nome` varchar(50) NOT NULL DEFAULT '---',
  `peca_nome` varchar(50) NOT NULL DEFAULT '---',
  `status` varchar(50) NOT NULL DEFAULT '0',
  `quantidade_peca` int(50) NOT NULL,
  `valor_peca` bigint(20) NOT NULL,
  `valor_servico` bigint(20) NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `pecas`
--

CREATE TABLE `pecas` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `quantidade` int(50) NOT NULL,
  `valor` bigint(20) NOT NULL,
  `codigo` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `pedido_compra`
--

CREATE TABLE `pedido_compra` (
  `id` int(11) NOT NULL,
  `empresa_id` int(11) NOT NULL,
  `peca_id` int(11) NOT NULL,
  `peca_nome` varchar(50) NOT NULL DEFAULT '---',
  `empresa_nome` varchar(50) NOT NULL DEFAULT '---',
  `status` varchar(20) NOT NULL DEFAULT 'Em Aberto',
  `quantidade` int(50) NOT NULL DEFAULT 0,
  `valor` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `registros`
--

CREATE TABLE `registros` (
  `id` int(11) NOT NULL,
  `cliente_id` int(11) NOT NULL DEFAULT -1,
  `empresa_id` int(11) NOT NULL DEFAULT -1,
  `peca_id` int(11) NOT NULL,
  `cliente_nome` varchar(50) NOT NULL DEFAULT '---',
  `empresa_nome` varchar(50) NOT NULL DEFAULT '---',
  `peca_nome` varchar(5) NOT NULL DEFAULT '---',
  `descricao` varchar(50) NOT NULL DEFAULT '---',
  `valor` double NOT NULL,
  `quantidade` int(20) NOT NULL DEFAULT -1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `solicitacoes_baixa`
--

CREATE TABLE `solicitacoes_baixa` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `id_peca` int(11) NOT NULL,
  `id_os` int(11) NOT NULL DEFAULT -1,
  `quantidade` int(50) NOT NULL,
  `motivo` varchar(100) DEFAULT NULL,
  `data_solicitacao` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `empresas`
--
ALTER TABLE `empresas`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `ordens_servico`
--
ALTER TABLE `ordens_servico`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `pecas`
--
ALTER TABLE `pecas`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `pedido_compra`
--
ALTER TABLE `pedido_compra`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `registros`
--
ALTER TABLE `registros`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `solicitacoes_baixa`
--
ALTER TABLE `solicitacoes_baixa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_peca` (`id_peca`),
  ADD KEY `id_os` (`id_os`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `empresas`
--
ALTER TABLE `empresas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `ordens_servico`
--
ALTER TABLE `ordens_servico`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `pecas`
--
ALTER TABLE `pecas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `pedido_compra`
--
ALTER TABLE `pedido_compra`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `registros`
--
ALTER TABLE `registros`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `solicitacoes_baixa`
--
ALTER TABLE `solicitacoes_baixa`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
