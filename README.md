	Copyright (c) 2012 Thomas Zink, 

	This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

# lib - Library and utilities

This is a collection of utility and library classes that are commonly
used in our projects, specifically UCE and P2P-RMI.

## Contents

* 	parent

	The parent project, i.e. all common settings and dependencies

* 	lib

	This is the builder project, i.e. it builds all modules.

* 	logger

	Our slf4j logger implementation which we use in all bundles.

* 	socketlistener

	A generic ServerSocket listener Thread implementation.
	It listenes on a server socket und uses the Executer framework
	to execute tasks.

*	test

	Generic Unit Test / Mockito helper classes used in some of our
	unit tests.

*	remotemessage

	Remote Interface for a remote messenger and a concrete implementation.

*	util

	Utility classes that implement functionality missing in the standard API
	that are frequently needed.

