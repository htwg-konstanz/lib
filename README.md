# lib - Library and utilities commonly used in UCE, P2P-RMI

## Contents

* pom.xml
	this is the builder project, i.e. it builds all modules.
* Parent
	the parent project, i.e. all common settings and dependencies
* Logger
	our slf4j logger implementation
* SocketListener
	a generic ServerSocket listener Thread implementation.
	It listenes on a server socket und uses the Executer framework
	to execute tasks.
