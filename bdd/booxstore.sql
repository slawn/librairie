-- phpMyAdmin SQL Dump
-- version 3.2.0.1
-- http://www.phpmyadmin.net
--
-- Serveur: localhost
-- Généré le : Mar 13 Décembre 2011 à 12:25
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


-- --------------------------------------------------------

--
-- Structure de la table `t_admin`
--

CREATE TABLE IF NOT EXISTS `t_admin` (
  `id_admin` int(11) NOT NULL AUTO_INCREMENT,
  `login_admin` varchar(50) NOT NULL,
  `mdp_admin` varchar(50) NOT NULL,
  PRIMARY KEY (`id_admin`),
  UNIQUE KEY `login_admin` (`login_admin`),
  UNIQUE KEY `login_admin_2` (`login_admin`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Contenu de la table `t_admin`
--


-- --------------------------------------------------------

--
-- Structure de la table `t_categorie`
--

CREATE TABLE IF NOT EXISTS `t_categorie` (
  `id_categorie` int(11) NOT NULL AUTO_INCREMENT,
  `nom_categorie` varchar(100) NOT NULL,
  PRIMARY KEY (`id_categorie`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `t_categorie`
--


-- --------------------------------------------------------

--
-- Structure de la table `t_client`
--

CREATE TABLE IF NOT EXISTS `t_client` (
  `id_client` int(11) NOT NULL AUTO_INCREMENT,
  `login_client` varchar(100) NOT NULL,
  `mdp_client` varchar(100) NOT NULL,
  `nom_client` varchar(100) DEFAULT NULL,
  `prenom_client` varchar(100) DEFAULT NULL,
  `adresse_postale_client` varchar(200) DEFAULT NULL,
  `email_client` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id_client`),
  UNIQUE KEY `login_client` (`login_client`),
  UNIQUE KEY `login_client_2` (`login_client`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `t_client`
--


-- --------------------------------------------------------

--
-- Structure de la table `t_commande`
--

CREATE TABLE IF NOT EXISTS `t_commande` (
  `id_commande` int(11) NOT NULL AUTO_INCREMENT,
  `id_client` int(11) NOT NULL,
  `date_commande` date DEFAULT NULL,
  `etat_commande` int(11) DEFAULT NULL,
  `adresse_postale_commande` varchar(500) DEFAULT NULL,
  `prix_commande` float DEFAULT NULL,
  PRIMARY KEY (`id_commande`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `t_commande`
--


-- --------------------------------------------------------

--
-- Structure de la table `t_livre`
--

CREATE TABLE IF NOT EXISTS `t_livre` (
  `id_livre` int(11) NOT NULL AUTO_INCREMENT,
  `id_categorie` int(11) DEFAULT NULL,
  `titre_livre` varchar(100) NOT NULL,
  `date_parution_livre` varchar(100) DEFAULT NULL,
  `sommaire_livre` varchar(500) DEFAULT NULL,
  `date_ajout_livre` date DEFAULT NULL,
  `etat_livre` tinyint(1) DEFAULT NULL,
  `auteur_livre` varchar(100) DEFAULT NULL,
  `nombre_vente_livre` int(11) DEFAULT NULL,
  `nombre_stock_livre` int(11) DEFAULT NULL,
  `quantite_reaprovisionnement_livre` int(11) DEFAULT NULL,
  `seuil_reaprovisionnement_livre` int(11) DEFAULT NULL,
  `prix_livre` float NOT NULL,
  PRIMARY KEY (`id_livre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `t_livre`
--


-- --------------------------------------------------------

--
-- Structure de la table `t_log`
--

CREATE TABLE IF NOT EXISTS `t_log` (
  `id_log` int(11) NOT NULL AUTO_INCREMENT,
  `id_admin` int(11) DEFAULT NULL,
  `id_client` int(11) DEFAULT NULL,
  `id_livre` int(11) DEFAULT NULL,
  `id_commande` int(11) DEFAULT NULL,
  `date_heure_log` datetime NOT NULL,
  `action_log` varchar(500) NOT NULL,
  `argument_log` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id_log`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `t_log`
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
