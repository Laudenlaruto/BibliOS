-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 15, 2017 at 12:57 PM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 7.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bnf`
--

-- --------------------------------------------------------

--
-- Table structure for table `cd`
--

CREATE TABLE `cd` (
  `titre` varchar(20) NOT NULL,
  `genre` varchar(20) NOT NULL,
  `auteur` varchar(20) NOT NULL,
  `compositeur` varchar(20) NOT NULL,
  `durée` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cd`
--

INSERT INTO `cd` (`titre`, `genre`, `auteur`, `compositeur`, `durée`) VALUES
('life', 'monde', 'le', 'lili', 212);

-- --------------------------------------------------------

--
-- Table structure for table `dvd`
--

CREATE TABLE `dvd` (
  `titre` varchar(20) NOT NULL,
  `genre` varchar(20) NOT NULL,
  `realisateur` varchar(20) NOT NULL,
  `acteur` varchar(20) NOT NULL,
  `durée` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dvd`
--

INSERT INTO `dvd` (`titre`, `genre`, `realisateur`, `acteur`, `durée`) VALUES
('Nemo', 'animation', 'pixar', 'nemo', 120);

-- --------------------------------------------------------

--
-- Table structure for table `emprunt`
--

CREATE TABLE `emprunt` (
  `nom` varchar(20) NOT NULL,
  `titre` varchar(20) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `emprunt`
--

INSERT INTO `emprunt` (`nom`, `titre`, `date`) VALUES
('john', 'Miserable', '2017-10-15'),
('john', 'L''apprenti', '2017-10-15');

-- --------------------------------------------------------

--
-- Table structure for table `livre`
--

CREATE TABLE `livre` (
  `titre` varchar(20) NOT NULL,
  `genre` varchar(20) NOT NULL,
  `auteur` varchar(20) NOT NULL,
  `nbpages` int(11) NOT NULL,
  `ISBN` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `livre`
--

INSERT INTO `livre` (`titre`, `genre`, `auteur`, `nbpages`, `ISBN`) VALUES
('Miserable', 'lit', 'hugo', 200, 'omizefmleznfùpzjpfz'),
('L''apprenti', 'Fantasy', 'JohnFlanagan', 150, 'FHEAPIHFPIAHF');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`nom`, `prenom`) VALUES
('john', 'doe');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
