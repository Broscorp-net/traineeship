#!/bin/sh
git fetch origin master:master
changed_files=$(git diff --name-only --diff-filter=ACMRT master | grep -e .class$ -e .iml$ -e .war$ -e .jar$ -e .xml$ -e .lst$ -e .idea| xargs)
if [ -z "$changed_files" ]
then
echo "It's okay. There are no prohibited files in your commit."
exit 0;
else
  echo "Error: There are files in your commit that shouldn't be there. Pay attention to the following extensions: .class, .iml, .war, .jar, .xml, .lst, .idea and delete their"
  echo $changed_files
exit 1;
fi
