-- phpMyAdmin SQL Dump
-- version 3.2.0.1
-- http://www.phpmyadmin.net
--
-- Serveur: localhost
-- Généré le : Jeu 15 Décembre 2011 à 17:07
-- Version du serveur: 5.1.36
-- Version de PHP: 5.3.0

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Base de données: `booxtore`
--

-- --------------------------------------------------------

--
-- Structure de la table `a_contenir`
--

CREATE TABLE IF NOT EXISTS `a_contenir` (
  `id_livre` int(11) NOT NULL,
  `nombre` int(11) NOT NULL,
  `id_commande` int(11) NOT NULL,
  PRIMARY KEY (`id_livre`,`id_commande`),
  KEY `id_commande` (`id_commande`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `a_contenir`
--


--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `a_contenir`
--
ALTER TABLE `a_contenir`
  ADD CONSTRAINT `a_contenir_ibfk_1` FOREIGN KEY (`id_livre`) REFERENCES `t_livre` (`id_livre`),
  ADD CONSTRAINT `a_contenir_ibfk_2` FOREIGN KEY (`id_commande`) REFERENCES `t_commande` (`id_commande`);
