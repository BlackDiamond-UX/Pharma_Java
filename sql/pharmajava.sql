-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 04 fév. 2021 à 20:15
-- Version du serveur :  10.4.17-MariaDB
-- Version de PHP : 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `pharmajava`
--

-- --------------------------------------------------------

--
-- Structure de la table `medic`
--

CREATE TABLE `medic` (
  `id` int(3) NOT NULL,
  `item` varchar(120) NOT NULL,
  `company` varchar(220) NOT NULL,
  `price` int(120) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `medic`
--

INSERT INTO `medic` (`id`, `item`, `company`, `price`) VALUES
(2, 'Doliprane', 'Youcode', 100),
(4, 'Panadole', 'Youcode', 70),
(5, 'Zinaskin', 'Covid19', 200),
(6, 'Renuphebral', 'Youcode', 250);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `medic`
--
ALTER TABLE `medic`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `medic`
--
ALTER TABLE `medic`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
