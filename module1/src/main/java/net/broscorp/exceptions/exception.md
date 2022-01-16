digraph G {
compound=true;

subgraph cluster_0 {
label="Checked";
"ClassNotFound";
"IOException";
}
subgraph cluster_1 {
label="Unchecked";
"Runtime" -> "NPE";
}

THR [label="Throwable\n(checked)"];
ERR [label="Error\n(unchecked)"];
EXC [label="Exception\n(checked)"];
OOM [label="OutOfMemoryError"];
SOF [label="StackOverflow"];

THR -> ERR;
THR -> EXC;
ERR -> OOM;
ERR -> SOF;
EXC -> Runtime[lhead=cluster_1];
EXC -> IOException[lhead=cluster_0];
}